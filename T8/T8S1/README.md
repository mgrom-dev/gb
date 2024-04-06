## Урок 2. Семинар. Механизм пространства имён
Задание скопировать команду ls в нашу корневую директорию созданную на прошлом уроке:
```bash
# получаем список зависимостей команды
ldd /bin/ls
        linux-vdso.so.1 (0x00007ffc015bf000)
        libselinux.so.1 => /lib/x86_64-linux-gnu/libselinux.so.1 (0x00007fcc58e17000)
        libc.so.6 => /lib/x86_64-linux-gnu/libc.so.6 (0x00007fcc58a26000)
        libpcre.so.3 => /lib/x86_64-linux-gnu/libpcre.so.3 (0x00007fcc587b5000)
        libdl.so.2 => /lib/x86_64-linux-gnu/libdl.so.2 (0x00007fcc585b1000)
        /lib64/ld-linux-x86-64.so.2 (0x00007fcc59261000)
        libpthread.so.0 => /lib/x86_64-linux-gnu/libpthread.so.0 (0x00007fcc58392000)

# смотрим файлы которые уже есть
ls GB/lib GB/lib64
GB/lib:
libc.so.6  libdl.so.2  libtinfo.so.5

GB/lib64:
ld-linux-x86-64.so.2

# копируем команду и зависимости
cp /bin/ls GB/bin
cp /lib/x86_64-linux-gnu/libselinux.so.1 GB/lib
cp /lib/x86_64-linux-gnu/libpcre.so.3 GB/lib
cp /lib/x86_64-linux-gnu/libpthread.so.0 GB/lib
sudo chroot GB

# выводим список всех файлов в директории и поддиректориях
ls -R
```

Посмотрим пространства имен связанные с текущим процессом:
```bash
ls -l /proc/$$/ns
total 0
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 cgroup -> 'cgroup:[4026531835]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 ipc -> 'ipc:[4026532242]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 mnt -> 'mnt:[4026532253]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 net -> 'net:[4026531840]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 pid -> 'pid:[4026532255]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 pid_for_children -> 'pid:[4026532255]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 time -> 'time:[4026531834]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 time_for_children -> 'time:[4026531834]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 user -> 'user:[4026531837]'
lrwxrwxrwx 1 turbid turbid 0 Apr  6 16:33 uts -> 'uts:[4026532254]'
```

Посмотреть задействованные пространства имен пользователем:
```bash
lsns
        NS TYPE   NPROCS   PID USER   COMMAND
4026531835 cgroup      4  1118 turbid -bash
4026531837 user        4  1118 turbid -bash
4026531840 net         4  1118 turbid -bash
4026532242 ipc         4  1118 turbid -bash
4026532253 mnt         4  1118 turbid -bash
4026532254 uts         4  1118 turbid -bash
4026532255 pid         4  1118 turbid -bash
```

### Утилитла unshare
Посмотреть описание unshare `man unshare`

Посмотреть пространство сетевых имен `ip netns list`  
Добавить новое сетевое пространство имен `ip netns add testns`  
Запустим в новом сетевом пространстве новый процесс `ip netns exec testns bash`  
Посмотрим текущее состояние сетевого интерфейса `ifconfig` или `ip a`  
Как видим доступен только один интерфейс **loopback**, если мы введем `exit`, то станут доступны снова все интерфейсы

Добавляем новый виртуальный сетевой интерфейс:
```bash
ip link add veth0 type veth peer name veth1
ip link set veth1 netns testns
# добавляем нашей виртуальной карточке ip адрес и запускаем его
ip addr add 10.0.0.1/24 dev veth0
ip link set dev veth0 up
# проверяем что виртуальный сетевой интерфейс добавился
ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host
       valid_lft forever preferred_lft forever
2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc mq state UP group default qlen 1000
    link/ether 00:15:5d:0b:9f:af brd ff:ff:ff:ff:ff:ff
    inet 172.23.12.103/20 brd 172.23.15.255 scope global eth0
       valid_lft forever preferred_lft forever
    inet6 fe80::215:5dff:fe0b:9faf/64 scope link
       valid_lft forever preferred_lft forever
4: veth0@if3: <NO-CARRIER,BROADCAST,MULTICAST,UP> mtu 1500 qdisc noqueue state LOWERLAYERDOWN group default qlen 1000
    link/ether e2:ca:de:c4:25:b1 brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 10.0.0.1/24 scope global veth0
       valid_lft forever preferred_lft forever
# Переходим в наше тестовое пространство и проверяем что виртуальный интерфейс доступен
ip netns exec testns bash
ip a
1: lo: <LOOPBACK> mtu 65536 qdisc noop state DOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
3: veth1@if4: <BROADCAST,MULTICAST> mtu 1500 qdisc noop state DOWN group default qlen 1000
    link/ether 7a:d0:4f:4f:84:54 brd ff:ff:ff:ff:ff:ff link-netnsid 0
# Добавляем ip адрес и запускаем интерфейс
ip add add 10.0.0.2/24 dev veth1
ip link set dev veth1 up
# проверяем что есть связь с внешним пространством
ping 10.0.0.1
PING 10.0.0.1 (10.0.0.1) 56(84) bytes of data.
64 bytes from 10.0.0.1: icmp_seq=1 ttl=64 time=0.546 ms
64 bytes from 10.0.0.1: icmp_seq=2 ttl=64 time=0.069 ms
64 bytes from 10.0.0.1: icmp_seq=3 ttl=64 time=0.051 ms
# очистим консоль
clear
```

Создание сетевого пространства с помощью утилитлы unshare
```bash
unshare --net /bin/bash
```

### Домашнее задание
Создать изолированное адресное пространство в том числе файловой системы с помощью утилитлы unshare, пример комманды:   
`unshare --pid --net --fork --mount-proc --mount --root=HW01 /bin/bash`