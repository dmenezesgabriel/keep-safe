# Keep Safe

Think smart & keep safe. We'll help you avoid any danger.

## Requirements

- JDK 17
- Maven 3.8.3

## Usage

Put your local jars like `ojdbc8.jar` in `external\lib\.put-jars-here`.
Change `src\main\resources\META-INF\persistence.xml` with your credentials.

## Development

### Styling

- Google code style (eclipse-formatter.xml)

### Running tests

**Compile**:

```sh
mvn clean package
```

or if already compiled:

**tests**:

```sh
mvn test
```

_Test using H2 in memory database._
