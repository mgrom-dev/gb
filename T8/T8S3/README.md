## Урок 6. Семинар. Введение в Docker
```bash
# запустим новый контейнер в интерактивном режиме с заданным hostname -h
docker run -it -h GB ubuntu:22.10 bash
# запустим команду в определенном контейнере
docker exec -it e7dc349ed743 hostname
# создадим еще один контейнер, зададим ему имя и после запуска, выйдем из него
docker run -it -h GB --name gb-test ubuntu:22.10
hostname
exit
# чтобы выйти из контейнера, без его завершения, нужно нажать ctrl+D
# также внутри контейнера нет комманд shutdown, reboot, так как они завершаются иначе
docker start gb-test
docker exec -it gb-test bash
docker ps -a
docker stop gb-test
# изменение файлов в контейнере
docker run -it -h GB --name gb-test ubuntu:22.10
ls -l
mkdir /example
touch /example/test.txt
echo "some text" >> /example/test.txt
cat /example/test.txt
exit
# создадим образ и смонтируем туда нашу локальную папку
mkdir /test
vi /test/test.txt
cat /test/test.txt
docker run -it -h gb-test --name gb-test -v /test:/example ubuntu:22.10
ls /
cat /example/test.txt
# если монтируем несколько сущностей, то при их совпадении, та сущность которая была создана позднее, перекроет ранее созданную.
# таким образом можно менять конфигурацию образа, пример:
docker run -it -h gb-test --name gb-test -v /test:/example -v /root/test.txt:/example/test.txt ubuntu:22.10
cat /example/test.txt
# запустим 2 контейнера в режиме демона -d с некоторыми заданными параметрами -env и установим связь между ними --link, сделаем проброс порта -p
docker run -d --name mariadb --env MARIADB_ROOT_PASSWORD=12345678 mariadb
docker run --name phpmyadmin -d --link mariadb:db -p 8081:80 phpmyadmin/phpmyadmin
docker ps -a
docket exec -it phpmyadmin bash
cat /etc/hosts
```
Примеры кодов статусов docker (в зависимости от версии контейнера, статусы бывают разные)
- Exited (0) - нормальное завершение контейнера
- Exited (127) - мы вышли из контейнера в ручном режиме
- Exited (137) - мы остановили контейнер с помощью docker, пример команды: `docker stop <container id>`, произошел kill контейнера, что не совсем хорошо.

### Домашнее задание
Запустить контейнер с БД, отличной от mariaDB, используя инструкции на сайте hub.docker.com.  
Добавить в контейнер hostname такой же, как hostname системы через переменную.  
Заполнить БД данными через консоль.  
Запустить phpmyadmin (в контейнере) и через веб проверить, что все введенные данные доступны.