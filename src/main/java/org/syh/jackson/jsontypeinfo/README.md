# Notes

## Use @JsonTypeInfo annotation to handle polymorphic types
```
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class Shape {
}
```