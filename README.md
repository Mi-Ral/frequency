# REST API для подсчета частоты символов

Это REST API предоставляет возможность рассчитать частоту встречи символов в заданной строке.

## Запуск приложения

1. Клонируйте репозиторий с кодом/загрузите приложение.
2. Убедитесь, что используете 17 JDK.
3. Запустите приложение с помощью команды `./mvnw spring-boot:run` / используйте вашу IDE.


После запуска, приложение будет доступно по адресу `http://localhost:8080`.

## Рассчет частоты символов

### Метод: GET 

### URL: /api/frequency


Этот метод позволяет рассчитать частоту символов в переданной строке.

#### Входящие параметры


- **inputString** (обязательный): Строка, для которой нужно рассчитать частоту символов.

Пример запроса:

`http://localhost:8080/api/frequency?inputString=aaaaabcccc`

#### Исходящие параметры
Результат будет возвращен в виде отсортированной map, где ключи - символы, значения - частота вхождений символа в строку.

Пример ответа:
```json
{
    "a": 5,
    "c": 4,
    "b": 1
}
```

#### Обработка ошибок
1. Если параметр **inputString** отсутствует в запросе, API вернет код состояния 400 Bad Request с сообщением об ошибке.
2. Если inputString пустая строка, API также вернет код состояния 400 Bad Request с сообщением об ошибке.