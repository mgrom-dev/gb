## Урок 10. Семинар. Docker Compose и Docker Swarm
Создадим сервис с 2мя контейнерами docker-compose.yml:
```yml
version: '3.9'
services:

    db:
        image: mariadb:10.10.2
        restart: always
        environment:
            MYSQL_ROOT_PASSWORD: 12345

    adminer:
        image: adminer:4.8.1
        restart: always
        ports:
            - 6080:8080

# запускаем файл
docker-compose up -d
docker ps -a
docker container inspect root_adminer_1
docker container inspect root_db_1
docker-compose logs db
docker-compose down
docker-compose images
```
Работает с docker swarm
```sh
# 1 нода главная manager
docker swarm init
docker node ls
# создадим 3 реплики сервиса и посмотрим результат
docker service create --name test1 --replicas 3 nginx:alpine
docker service ps test1
docker service rm test1
# создадим в глобальном режиме (сервис, реплики создаются по количеству нод)
docker service create --mode=global --name test1 nginx:alpine
docker service rm test1
# scale масштабирование реплик
docker service create --name test1 --replicas 3 nginx:alpine
docker service scale test1=1
docker service ps test1
docker service scale test1=3
docker service ps test1
docker service rm test1

# если ошибка и docker swarm не может определить ip адрес, то можно сделать это вручную
docker swarm init --advertise-addr 1.1.90.90

# 2 нода, вставляем команду полученную из 1 ноды
docker swarm join --token SWMTKN...

# 3 нода
docker swarm join --token SWMTKN...
```
Важно заметить что при превышении количества реплик, больше чем нод, то создаются дубли на одних и тех же нодах.

Работаем с сетями
```sh
# посмотрим список сетей на всех нодах и видим что сеть ingress имеет один id на всех нодах
docker network ls
# создадим виртуаьную сеть
docker network create --driver overlay --subnet 4.5.6.0/24 test-network --attachable
docker network ls
# 1 нода
docker run -d --ip 4.5.6.7 --network test-network --name con-1 busybox sleep 3600
# 2 нода
docker run -d --ip 4.5.6.8 --network test-network --name con-2 busybox sleep 3600
docker exec -it con-2 sh
ping 4.5.6.7
# если сеть не появляется на какой-то ноде, можно сделать promote node
docker node promote docker-3
docker stop con-1
docker rm con-1
docker stop con-2
docker rm con-2
docker network rm test-network
```
Домашнее задание
Задание 1:
1) создать сервис, состоящий из 2 различных контейнеров: 1 — веб, 2 — БД
2) далее необходимо создать 3 сервиса в каждом окружении (dev, prod, lab)
3) по итогу, на каждой ноде должно быть по 2 работающих контейнера
4) выводы зафиксировать

Задание 2*:
1) нужно создать 2 ДК-файла, в которых будут описываться сервисы
2) повторить задание 1 для двух окружений: lab, dev
3) обязательно проверить и зафиксировать результаты, чтобы можно было выслать преподавателю для проверки.

```sh
# добавляем метки
docker node update --label-add env=prod docker-1
docker node update --label-add env=dev docker-2
docker node update --label-add env=lab docker-3
docker node inspect docker-3
docker service create --name nginx-1 --constraint node.labels.env==prod --replicas 2 nginx
docker service ps nginx-1
docker service create --name nginx-2 --constraint node.labels.env==dev --replicas 2 nginx
docker service ps nginx-2
docker serivce rm nginx-1
docker serivce rm nginx-2
docker serivce rm nginx-3
```

```sh
# Инициализируем главную ноду
docker swarm init
Swarm initialized: current node (pf2ybwa2mvwj3xvd42lmqgzbj) is now a manager.

To add a worker to this swarm, run the following command:

    docker swarm join --token SWMTKN-1-3ue0j93jk8bjp7ph24i9ovb594htfxdz7wzlgy1u4241ihphw6-6bdsa362zuxsjcyoydny6qkp4 192.168.65.3:2377

To add a manager to this swarm, run 'docker swarm join-token manager' and follow the instructions.

# создадим виртуальную сеть
docker network create --driver overlay --subnet 4.5.6.0/24 test-network --attachable 
qcnfgc2bjgbvninzfffumk80t

# установим portainer
curl -L https://downloads.portainer.io/portainer-agent-stack.yml -o portainer-agent-stack.yml
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   791  100   791    0     0   2321      0 --:--:-- --:--:-- --:--:--  2333
docker stack deploy -c portainer-agent-stack.yml portainer
Creating network portainer_agent_network
Creating service portainer_agent
Creating service portainer_portainer
docker service ls
ID             NAME                  MODE         REPLICAS   IMAGE                           PORTS
m1mtroe665a3   portainer_agent       global       0/1        portainer/agent:2.11.1
inloii2fkwah   portainer_portainer   replicated   0/1        portainer/portainer-ce:2.11.1   *:8000->8000/tcp, *:9000->9000/tcp, *:9443->9443/tcp

# создадим 2 виртуальных сервера под ноды
# 1 нода docker-slave-1
docker run --privileged --name docker-slave-1 -h docker-sl-1 -d --network test-network -p 8081:80 docker:24.0.9-dind-alpine3.19
docker exec -it docker-slave-1 sh
docker swarm join --token SWMTKN-1-3ue0j93jk8bjp7ph24i9ovb594htfxdz7wzlgy1u4241ihphw6-6bdsa362zuxsjcyoydny6qkp4 192.168.65.3:2377
This node joined a swarm as a worker.

# 2 нода docker-slave-2
docker run --privileged --name docker-slave-2 -h docker-sl-2 -d --network test-network -p 8082:80 docker:24.0.9-dind-alpine3.19
docker exec -it docker-slave-2 sh
docker swarm join --token SWMTKN-1-3ue0j93jk8bjp7ph24i9ovb594htfxdz7wzlgy1u4241ihphw6-6bdsa362zuxsjcyoydny6qkp4 192.168.65.3:2377
This node joined a swarm as a worker.

# Добавим метки нодам
docker node ls
docker node update --label-add env=prod docker-desktop
docker node update --label-add env=dev docker-sl-1
docker node update --label-add env=lab docker-sl-2

# Запускаем сервисы 
# https://docs.docker.com/engine/swarm/ingress/ - обход сетки маршрутизации
docker service create --network test-network --constraint node.labels.env==dev --name testmysql -e MYSQL_ROOT_PASSWORD=passwd mysql
docker service create --network test-network -e PMA_HOST=testmysql --constraint node.labels.env==dev --name phpmyadmin -p 80:80 phpmyadmin/phpmyadmin

docker service create --network test-network --constraint node.labels.env==lab --name testmysql-2 -e MYSQL_ROOT_PASSWORD=passwd mysql
docker service create --network test-network -e PMA_HOST=testmysql-2 --constraint node.labels.env==lab --name phpmyadmin-2 -p 8082:80 phpmyadmin/phpmyadmin

docker service ls
ID             NAME                  MODE         REPLICAS   IMAGE                           PORTS
ygr9pu0rrz5m   phpmyadmin            replicated   1/1        phpmyadmin/phpmyadmin:latest    *:80->80/tcp
lwf93bfraqz5   phpmyadmin-2          replicated   1/1        phpmyadmin/phpmyadmin:latest    *:8082->80/tcp
m1mtroe665a3   portainer_agent       global       1/2        portainer/agent:2.11.1
inloii2fkwah   portainer_portainer   replicated   1/1        portainer/portainer-ce:2.11.1   *:8000->8000/tcp, *:9000->9000/tcp, *:9443->9443/tcp
pnebgx46cpho   testmysql             replicated   1/1        mysql:latest
iztfljfqq7lb   testmysql-2           replicated   1/1        mysql:latest

# Удалим запущенные сервисы
docker service rm phpmyadmin
docker service rm phpmyadmin-2
docker service rm testmysql
docker service rm testmysql-2
docker container prune -f
docker image prune -f
docker volume prune -f
docker system prune
```

```sh
# создадим еще раз виртуальную сеть и 2 виртуальных сервера
docker network create --driver overlay --subnet 4.5.6.0/24 test-network --attachable
rx1suat9tonjn8eluiuggbmnz
docker run --privileged --name docker-slave-1 -h docker-sl-1 -d --network test-network -p 8081:80 docker:24.0.9-dind-alpine3.19
0d7eed50d35078815ea1a94038c4edd65ea69a92c2a47c56a5d7153ef7ff5318
docker exec -it docker-slave-1 sh
docker swarm join --token SWMTKN-1-3ue0j93jk8bjp7ph24i9ovb594htfxdz7wzlgy1u4241ihphw6-6bdsa362zuxsjcyoydny6qkp4 192.168.65.3:2377
This node joined a swarm as a worker.
docker run --privileged --name docker-slave-2 -h docker-sl-2 -d --network test-network -p 8082:80 docker:24.0.9-dind-alpine3.19
ac2dbb66efbb3bd29e6c0a657ec67c64d3cb5589a88a313447f36bbbab04267b
docker exec -it docker-slave-2 sh
docker swarm join --token SWMTKN-1-3ue0j93jk8bjp7ph24i9ovb594htfxdz7wzlgy1u4241ihphw6-6bdsa362zuxsjcyoydny6qkp4 192.168.65.3:2377
This node joined a swarm as a worker.
docker node update --label-add env=dev docker-sl-1
docker-sl-1
docker node update --label-add env=lab docker-sl-2
docker-sl-2
docker ps -a
CONTAINER ID   IMAGE                           COMMAND                  CREATED              STATUS             PORTS                                 NAMES
ac2dbb66efbb   docker:24.0.9-dind-alpine3.19   "dockerd-entrypoint.…"   45 seconds ago       Up 42 seconds      2375-2376/tcp, 0.0.0.0:8082->80/tcp   docker-slave-2
0d7eed50d350   docker:24.0.9-dind-alpine3.19   "dockerd-entrypoint.…"   About a minute ago   Up 59 seconds      2375-2376/tcp, 0.0.0.0:8081->80/tcp   docker-slave-1
bea183123011   portainer/portainer-ce:2.11.1   "/portainer -H tcp:/…"   About an hour ago    Up About an hour   8000/tcp, 9000/tcp, 9443/tcp          portainer_portainer.1.jf0gpycnn9h7t3m9brpdotate
8c30b6950777   portainer/agent:2.11.1          "./agent"                About an hour ago    Up About an hour                                         portainer_agent.pf2ybwa2mvwj3xvd42lmqgzbj.qy653csrut8jt3jwkwce00bxe
```

```yml
# Создадим stack в файле docker-compose.yml

version: "3.9"

services:
  phpmyadmin:
    image: phpmyadmin/phpmyadmin
    ports:
      - "80:80"
    environment:
      PMA_HOST: testmysql
    extra_hosts:
      - host.docker.internal:host-gateway
    networks:
      - test-network
    deploy:
      placement:
        constraints:
          - node.labels.env == dev
  
  testmysql:
    image: mysql
    networks:
      - test-network
    environment:
      MYSQL_ROOT_PASSWORD: passwd
    deploy:
      placement:
        constraints:
          - node.labels.env == dev

  phpmyadmin-2:
    image: phpmyadmin/phpmyadmin
    ports:
      - "8082:80"
    environment:
      PMA_HOST: testmysql-2
    extra_hosts:
      - host.docker.internal:host-gateway
    networks:
      - test-network
    deploy:
      placement:
        constraints:
          - node.labels.env == lab
  
  testmysql-2:
    image: mysql
    networks:
      - test-network
    environment:
      MYSQL_ROOT_PASSWORD: passwd
    deploy:
      placement:
        constraints:
          - node.labels.env == lab

networks:
  test-network:
    external: true
```

```sh
# запустим стек
docker stack deploy --with-registry-auth -c ./docker-compose.yml sql_admin;
```

```sh
# проверяем контейнеры и доступность
docker stack ls
NAME        SERVICES
portainer   2
sql_admin   4
docker service ls
ID             NAME                     MODE         REPLICAS   IMAGE                           PORTS
m1mtroe665a3   portainer_agent          global       1/3        portainer/agent:2.11.1
inloii2fkwah   portainer_portainer      replicated   1/1        portainer/portainer-ce:2.11.1   *:8000->8000/tcp, *:9000->9000/tcp, *:9443->9443/tcp
5vi5903oyose   sql_admin_phpmyadmin     replicated   1/1        phpmyadmin/phpmyadmin:latest    *:80->80/tcp
ky5w7ecqipy7   sql_admin_phpmyadmin-2   replicated   1/1        phpmyadmin/phpmyadmin:latest    *:8082->80/tcp
6cxh4jh96efl   sql_admin_testmysql      replicated   1/1        mysql:latest
fku6am3uvceb   sql_admin_testmysql-2    replicated   1/1        mysql:latest
docker node ls
ID                            HOSTNAME         STATUS    AVAILABILITY   MANAGER STATUS   ENGINE VERSION
pf2ybwa2mvwj3xvd42lmqgzbj *   docker-desktop   Ready     Active         Leader           25.0.3
pck1q39s8itan1r5n3r5gi5mn     docker-sl-1      Ready     Active                          24.0.9
dqbdel8zku6ikx8p82negb7sd     docker-sl-2      Ready     Active                          24.0.9
docker ps
CONTAINER ID   IMAGE                           COMMAND                  CREATED          STATUS          PORTS                                 NAMES
ac2dbb66efbb   docker:24.0.9-dind-alpine3.19   "dockerd-entrypoint.…"   18 minutes ago   Up 17 minutes   2375-2376/tcp, 0.0.0.0:8082->80/tcp   docker-slave-2
0d7eed50d350   docker:24.0.9-dind-alpine3.19   "dockerd-entrypoint.…"   18 minutes ago   Up 18 minutes   2375-2376/tcp, 0.0.0.0:8081->80/tcp   docker-slave-1
bea183123011   portainer/portainer-ce:2.11.1   "/portainer -H tcp:/…"   2 hours ago      Up 2 hours      8000/tcp, 9000/tcp, 9443/tcp          portainer_portainer.1.jf0gpycnn9h7t3m9brpdotate
8c30b6950777   portainer/agent:2.11.1          "./agent"                2 hours ago      Up 2 hours                                            portainer_agent.pf2ybwa2mvwj3xvd42lmqgzbj.qy653csrut8jt3jwkwce00bxe

[Ссылка на домашнюю работу](https://docs.google.com/document/d/102GXrQoc3HSIfqf54JgXW9SSBUOQ70IMejdmRT6_v8s/edit)