## Знакомство с языками программирования (лекции)
### Урок 1. Введение
---
**Полезные ссылки:**
> Обход прокси онлайн:  
https://www.genmirror.com/

> dotnet c#:  
https://dotnet.microsoft.com/

> id расширения для vscode c#:  
ms-dotnettools.vscode-dotnet-runtime
---
### Настройки расширения c# для vscode:
Если dotnet уже установлен
```JSON
"dotnetAcquisitionExtension.existingDotnetPath": [
    {
        "extensionId": "ms-dotnettools.csdevkit",
        "path": "C:\\Program Files\\dotnet\\dotnet.exe"
    },
    {
        "extensionId": "ms-dotnettools.vscodeintellicode-csharp",
        "path": "C:\\Program Files\\dotnet\\dotnet.exe"
    },
    {
        "extensionId": "ms-dotnettools.csharp",
        "path": "C:\\Program Files\\dotnet\\dotnet.exe"
    },
    {
        "extensionId": "ms-dotnettools.vscode-dotnet-runtime",
        "path": "C:\\Program Files\\dotnet\\dotnet.exe"
    }
]
```
---
### Создание консольного приложения на c# из терминала
* создаем новую ветку
* dotnet new console (--no restore, чтобы создать без возможности ввостановления)
* переносим изменения (Program.cs)
* dotnet run - запуск приложения
* dotnen publish - сборка приложения
---
### Домашняя работа:
Вычислить значение формулы:
<table>
    <tr><td><i>a x b</y></td></tr>
    <tr><td><i>c + d</i></td></tr>
</table>
где a, b, c, d – некоторые целые числа. Результат вывести на экран.