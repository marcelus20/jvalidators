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

After doing the above steps, you will be able to import this lib into your project:
```xml
    <dependency>
      <groupId>com.marcelus.validators</groupId>
      <artifactId>jvalidators</artifactId>
      <version>1.0.1-SNAPSHOT</version>
    </dependency>
```
PS: To see what releases are available, check the [tags](https://github.com/marcelus20/jvalidators/tags) page.

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

### When more features are going to be added? 
R: I don't have a fixed schedule for adding them nor do I know what more features to add. 
If I come across a situation that I need to validate something, and this validation doesn't exist in this lib,
I'll go ahead and add it. 

If you have an idea of what more to add, you can fill free to open an issue or open a pull request for us to discuss. 

### When will you add it to maven central?
R: I don't know. Perhaps if more people use it and this lib grows somehow. 

---
### Contributions
Feel free to contribute, just please consider the following: 
- Validators methods should return an Either object, where the left indicates the failure and right the success. Create methods that follow this approach.
- All jvalidators software is distributed under the GNU General Public open source license, and your contributions will be licensed in the same way.
- Open Pull Requests with the new codes containing passing test cases. 
- Create an issue if you want to discuss a new idea.

## License
[GNU GENERAL PUBLIC LICENSE](LICENSE)
