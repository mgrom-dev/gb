# Введение в контроль версий (семинары)
## Урок 1. Первое использование контроля версий
## Урок 2. Второе использование контроля версий
Ссылка для скачивания [git](https://git-scm.com/downloads)  
Перед первым использованием необходимо задать *имя пользователя* и *электронную почту*, для этого используются комманды:  
* git config --global user.name "***имя пользователя***"
* git config --global user.email "***электронная почта***"
## Основные команды гит
|<div style="width:160px">Команда</div>|Описание|
|-|-|
|git init|инициализация репозитория в текущем каталоге, создается скрытая папка .git|
|git add "**file**"|добавить изменения в **файле**, для добавления всех измений, можно использовать *"git add ."*|
|git commit -m "**message**"|зафиксировать все изменения, добавленные командой *git add*, **message** - описание изменений|
|git status|показывает текущее состояние репозитория|
|git diff|показывает различия между зафиксированными изменениями и текущем состоянием репозитория|
|git log|показывает список коммитов, для перемещения по истории используются стрелочки на клавиатуре, для выхода из режима просмотра клавиша **Q**|
|git checkout **commit**|переключиться на предыдущий **коммит**, можно использовать первые 4 символа id коммита, для возврата в актуальное состояние *git checkout master*|
|git checkout **branch_name**|переключиться на ветку с именем *branch_name*|
|git reset --hard **commit**|Сброс истории коммитов до указаного *commit*, все последующие коммиты, которые были после него будут стерты из истории без возможности ввостановления|
|git revert **commit**|Отменяет одиночный *commit*, но не возвращает проект в предшествовавшее состояние с удалением всех последующих коммитов. Это может быть полезно, если баг появился в проекте из-за конкретного коммита.|

## Дополнительные комманды
* **git commit --amend -m "message"** - изменить описание последнего коммита
* Дополнительные комманды **git log**:
    * **git log --graph --oneline --decorate** - Просмотреть историю коммитов в виде графика для текущей ветки
    * **git log -n limit** - Ограничивает число выводимых коммитов с помощью параметра *limit*
    * **git log --oneline** - Записывает каждый коммит в одну строку. Так можно получить подробный обзор всей истории проекта
    * **git log --author="author"** - Поиск коммитов от определенного автора *author*
    * **git log file** - Выводит только коммиты, содержащие указанный файл. Так можно удобно просмотреть историю *file*.
* **git clone url** - клонирование удаленного репозитория. В качестве параметра url передается адрес удаленного репозитория. Команда инициализирует новый репозиторий git в текущей директории и наполняет его содержимым удаленного репозитория.  
    * **git clone url path** - Клонирование удаленного репозитория в выбранную директорию path.
    * **git clone --branch branch_name url** - Клонирование ветки с именем branch_name из удаленного репозитория
    * **git clone -depth=1 url** - Клонирование удаленного репозитория с поверхностным копированием истории коммитов. В данном случае создается клон только с последним коммитом. Помогает при работе с репозиториями с большой историей коммитов.
* Привязка удаленного репозитория:
    * **git remote add remote_name url** - Эта команда привяжет удаленный репозиторий по адресу *url* к локальному репозиторию *remote_name*. После привязки удаленного репозитория в него можно будет отправлять локальные ветки с помощью команды push.
    * **git push -u remote_name branch_name** - Эта команда поместит ветку локального репозитория с именем *branch_name* в удаленный репозиторий *remote_name*