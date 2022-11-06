# jvalidators
Utility lib input validation following the Either approach.

## To install
This library is not available in the maven central for now, therefore you will need to clone this repo:
```shell
git clone https://github.com/marcelus20/jvalidators
```
Cd into the folder:
```shell
cd jvalidators
```

Issue the *maven clean install* command:
```shell
mvn clean install
```

After doing the abobve steps, you will be able to import this lib into your project:
```xml
    <dependency>
      <groupId>com.marcelus.validators</groupId>
      <artifactId>jvalidators</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>
```
---
## Current Features: 

**[ArrayValidator](src/main/java/com/marcelus/validators/ArrayValidator.java)**.arrayCorrectSize(): Validates an array by checking if it contains the correct size.

Example:
```java 
    // Given
    Integer[] intArray = new Integer[]{1,5,10};
    Integer correctSize = 3;
    // When
    Either result = ArrayValidator.arrayCorrectSize(intArray, correctSize);
    // Then
    Assertions.assertTrue(result.isRight());
```
In the example above, the either.right() will return. 

PS: If a either.left() returns, then an empty array of objects will be returned with fixed size of 0.

---

**[ListValidator](src/main/java/com/marcelus/validators/ListValidator.java).listCorrectSize()**: Validates a list by checking if it contains the correct size.
Example:
```java 
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        Integer correctSize = 50;
        // When
        Either result = ListValidator.listCorrectSize(intArray, correctSize);
        // Then
        Assertions.assertTrue(result.isLeft());
```
PS: either.left() returns an empty list.

---

**[NullValidator](src/main/java/com/marcelus/validators/NullValidator.java).notNull()**: 
validates any input by checking if it is not null.

Null Arrays will return an Either.left of an array of objects with a fixed size 0.

Null Lists will return an Either.left of an empty list of the original type.
```java 
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        Integer correctSize = 50;
        // When
        Either result = ListValidator.listCorrectSize(intArray, correctSize);
        // Then
        Assertions.assertTrue(result.isLeft());
```
PS: In the example above, the Either.left is an empty list of type Integer.

---
## FAQ

### When will you add more features
R: I don't know. When I find the need to add them.

### When will you add it to maven central?
R: I don't know. I'll basically keep adding more features to this lib, when I find the need, I'll do so.

---
### Contributions
Feel free to contribute, just please consider the following: 
- Validators methods should return an Either object, where the left indicates the failure and right the success. Create methods that follow this approach.
- All jvalidators software is distributed under the GNU General Public open source license, and your contributions will be licensed in the same way.
- Open Pull Requests with the new codes always containing Junit tests cases. 
- Create an issue if you want to discuss a new idea.

## License
[GNU GENERAL PUBLIC LICENSE](LICENSE)