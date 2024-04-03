## Урок 3. Продвинутая работа с исключениями в Java
План урока:
- Блок try-with-resources
- Обработка исключений на уровне выше по стеку
- Собственные типы исключений

### Блок try-with-resources
При использовании внешних для JVM ресурсов, таких как файлы, сетевые соединения, соединения с базами данных и прочие, требуется обязательно закрывать их в блоке finally. Это связано с тем, что если приложение аварийно завершит свою работу, JVM сама почистит используемую память и освободит все свои служебные файлы. Но если ваше приложение получило доступ к сетевым соединениям, файлам или соединениям с базами данных, все эти ресурсы будут внешними для JVM, и она никак на них не сможет повлиять. Поэтому вы обязательно должны их освобождать, иначе всё заблокируете.

В примере ниже читаем содержимое файла для решения какой-то задачи, детали этой задачи не важны. В блоке finally освобождаем файл.

```Java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainApp {
    public static void main(String args[]) {
        FileReader reader = null;
        try {
            reader = new FileReader(new File("file.txt"));
            // Полезная работа, связанная с чтением файла..
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Выглядит код очень громоздко, блок finally занимает даже больше места, чем основная логика метода. Было бы неплохо упростить этот код. Для этого используем конструкцию try-with-resources. Код примет вид:

```Java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainApp {
    public static void main(String args[]) {
        try (FileReader reader = new FileReader(new File("file.txt"))) {
            // Полезная работа, связанная с чтением файла..
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Рядом с try в круглых скобках указывается создаваемый ресурс, который при выходе из блока try должен быть освобождён, и не важно будет ли брошено какое-то исключение или нет. То есть вся работа по написанию блока finally выполняется автоматически без нашего участия.

Java определяет, что указанный объект в круглых скобках можно закрыть. Можно указать только объекты, реализующие интерфейс AutoClosable. В таком случае для Java есть гарантия возможности вызова метода close() у объекта.

```Java
public class MainApp {
    public static void main(String[] args) {
        try (Box box = new Box()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Box implements AutoCloseable {
    @Override
    public void close() throws Exception {
        // Закрываем коробку
    }
}
```

Использование нескольких объектов в блоке try-with-resources:

```Java
public class MainApp {
    public static void main(String[] args) {
        try (Box box1 = new Box(); Box box2 = new Box()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

При работе с внешними ресурсами в коде старайтесь использовать try-with-resources. Это гарантирует, что вы не забудете закрыть ресурс в блоке finally, и значительно уменьшит количество кода.

### Обработка исключений выше по стеку
Бывают ситуации, когда как бы ни старались, вы не сможете корректно выполнить обработку исключения, при этом у вызывающего кода такая возможность есть, и исключения потребуется до него добросить. 

Например мы не знаем, кто и в каком окружении будет использовать нашу библиотеку: в консоли, окне, веб-приложении. Получается, как бы ни хотелось защитить пользователя нашей библиотеки от такой ошибки, мы не можем ничего сделать. Потому что просто невозможно на нашем уровне корректно обработать исключение. Есть ли решение? Да, воспользуется ключевым словом throws.

```Java
package com.xlsreport.maker;
import java.io.IOException;
import java.io.PrintWriter;

public void saveReportToFile(String path, String data) throws IOException {
    String modifiedOutputData = data; // Представим, что здесь форматируются входные данные
    try (PrintWriter writer = new PrintWriter(path)) {
        writer.println(modifiedOutputData);
    }
}
```

```Java
public class MainAppWindow extends JFrame {
    public void onSaveReportButtonClick() {
        String path = generateOutputReportPath();
        String outputData = "Очень важные данные для отчета";
        ReportExporter reportExporter = new ReportExporter();
        try {
            reportExporter.saveReportToFile(path, outputData);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка! Невозможно сохранить отчет", "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
```

JOptionPane.showMessageDialog() показывает окно с сообщением об ошибке. Теперь при успешном сохранении отчёта пользователи смогут работать дальше, а в случаях отсутствия диска D:/ они получат окно с сообщением об ошибке и смогут сразу же обратиться к разработчику.

Если нам понадобилось обработать исключение в двух местах: и в библиотеке, и в клиентском коде, мы можем обработать исключение и повторно его бросить, чтобы клиентский код тоже мог его обработать:

```Java
package com.xlsreport.maker;
import java.io.IOException;
import java.io.PrintWriter;

public void saveReportToFile(String path, String data) throws IOException {
    String modifiedOutputData = data; // Представим, что здесь форматируются входные данные
    try (PrintWriter writer = new PrintWriter(path)) {
        writer.println(modifiedOutputData);
    } catch (IOException e) {
        // Что-то полезное делаем
        throw e;
    }
}
```

### Создание собственных типов исключений
В языке Java помимо стандартных исключений, есть возможность использования собственных типов исключений. Чтобы создать новое исключение, надо всего лишь создать новый класс и унаследовать его от одного из существующих типов исключений

```Java
public class MyException extends RuntimeException {
}
```

Использование:

```Java
public class MainApp {
    public static void main(String[] args) {
        throw new MyException();
    }
}
```

**Зачем создавать новые типы исключений, ведь в стандартной Java-библиотеке достаточно встроенных типов?** 

В проекте вам может потребоваться бросать исключения, связанные со спецификой решения какой-то задачи. Например, вы решили создать библиотеку для обработки изображений, и в этой библиотеке есть метод, позволяющий загрузить изображение в память. Но ваш код поддерживает не все возможные форматы.

**Если вы унаследовали класс от Checked-исключения, то и ваше исключение будет Checked, в противном случае — Unchecked.**

Все исключения, характерные для вашей библиотеки или проекта, было бы логично сгруппировать, чтобы у них был общий корень. Посмотрим, что это значит

```Java
public class JavaCVException extends RuntimeException {
}

public class IllegalImageFormatException extends JavaCVException {
}

public class IllegalFilterParametersException extends JavaCVException {
}
```

Создали корневое исключение JavaCVException (Java Computer Vision) и унаследовали остальные специфические исключения от него. Это даёт очень интересный эффект

```Java
public class MainApp {
    public static void main(String[] args) {
        try {
            cvLib.loadImage("C:/image.png");
        } catch (JavaCVException e) {
            e.printStackTrace();
        }
    }
}
```

Пока пользователь начинает работу с вашей библиотекой, он может везде перехватывать корневое исключение, не волнуясь, что приложение упадёт. Как только он получит достаточно опыта, то сможет начать менять код и указывать реакцию на уже конкретные исключения.

```Java
public class MainApp {
    public static void main(String[] args) {
        try {
            CvImage img =
            cvLib.loadImage("C:/image.png");
            cvLib.filters().blur(img, 2);
        } catch (IllegalImageFormatException e) {
            System.out.println("Выбрано изображение с неподдерживаемым форматом, выберите другой файл");
        } catch (IllegalFilterParametersException e) {
            System.out.println("Выбраны некорректные параметры фильтра");
        } catch (JavaCVException e) {
            System.out.println("Ой");
        }
    }
}
```

Ещё один интересный подход при работе с собственными типами исключений — «оборачивание» одного исключения в другое. Например, мы реализуем метод размытия изображения, и где-то в логике очень редко вылетает исключение, которое мы не учли.

```Java
public class JavaCVLibFilters {
    public void blur(CvImage img, int kernelSize) {
        try {
            // Вычисления
            // Вычисления
            // Вычисления
        } catch (Exception e) {
            throw new IllegalFilterParametersException();
        }
    }
}
```

Добавим немного особенностей нашим исключениям. Допустим, мы решили написать метод, преобразующий массив строк в массив целых чисел.

Если во входном массиве попадётся строка, которую невозможно преобразовать к целому числу, получим исключение NumberFormatException.

А если потребуется вместо этого бросить своё исключение, и чтобы исключение хранило информацию об индексе некорректного элемента? Тогда немного модифицируем код. Позволим исключению хранить в себе информацию о некорректном элементе массива.

```Java
public class ArrayTransformationException extends RuntimeException {
    private int illegalElementIndex;
    private String illegalElementValue;

    public int getIllegalElementIndex() {
        return illegalElementIndex;
    }

    public String getIllegalElementValue() {
        return illegalElementValue;
    }

    public ArrayTransformationException(int illegalElementIndex, String illegalElementValue) {
        super(String.format("Во входном массиве на позиции: %d находится некорректный элемент: %s", illegalElementIndex, illegalElementValue));
        this.illegalElementIndex = illegalElementIndex;
        this.illegalElementValue = illegalElementValue;
    }
}
```

В первой строке конструктора заполняем сообщение, которое будет выведено в консоль, через конструктор родителя. Посмотрим, как этим теперь пользоваться.

```Java
public class MainApp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(transform(new String[]{"1", "2", "3", "4"})));
    }

    public static int[] transform(String[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            try {
                output[i] = Integer.parseInt(input[i]);
            } catch (NumberFormatException e) {
                throw new ArrayTransformationException(i, input[i]);
            }
        }
        return output;
    }
}
```

Если в процессе преобразования вылетит стандартный NumberFormatException, мы его перехватим и обернём в собственный тип исключения, передав в его конструктор детализацию об ошибке. Теперь специально укажем некорректный массив и посмотрим, что выведется в консоль.

```Java
public class MainApp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(transform(new String[]{"1", "2a", "3", "4"})));
    }
}

Результат в консоли:
Exception in thread "main" ArrayTransformationException: Во входном массиве на позиции: 1 находится некорректный элемент: 2a
    at MainApp.transform(MainApp.java:14)
    at MainApp.main(MainApp.java:5)
```

Если потребуется, вы можете перехватить исключение, и через геттеры запросить у него либо индекс «битого» элемента, либо его значение.
