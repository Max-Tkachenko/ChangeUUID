# ChangeUUID

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2bf0e760440f4e44a2af310bb022c399)](https://www.codacy.com/app/Max-Tkachenko/ChangeUUID?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Max-Tkachenko/ChangeUUID&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Max-Tkachenko/ChangeUUID.svg?branch=master)](https://travis-ci.org/Max-Tkachenko/ChangeUUID)
[![Coverage Status](https://coveralls.io/repos/github/Max-Tkachenko/ChangeUUID/badge.svg?branch=master)](https://coveralls.io/github/Max-Tkachenko/ChangeUUID?branch=master)

RU:
Последовательность liquibase-миграций, которые позволяют в базе данных заменить идентификаторы всех записей (id) типа int на универсальный код UUID без потери связей между таблицами. Этот метод часто используется в тех ситуациях, когда база данных хранит очень большое количество записей и нужно избежать дублирования/совпадения идентификаторов. 

Результат Travis CI может быть красным, поскольку закончился хостинг.
