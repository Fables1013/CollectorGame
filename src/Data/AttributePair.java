package Data;

import Model.TypeAttribute;

import java.util.Arrays;
import java.util.List;

public class AttributePair {
    TypeAttribute firstAttribute;
    TypeAttribute secondAttribute;

    public AttributePair(TypeAttribute firstAttribute, TypeAttribute secondAttribute) {
        this.secondAttribute = secondAttribute;
        this.firstAttribute = firstAttribute;
    }

    public AttributePair(TypeAttribute firstAttribute) {
        this.firstAttribute = firstAttribute;
        this.secondAttribute = TypeAttribute.None;
    }

    public int countMatchingAttributes(AttributePair otherPair) {
        boolean firstMatches = (firstAttribute == otherPair.getFirstAttribute() ||
                firstAttribute == otherPair.getSecondAttribute()) && firstAttribute != TypeAttribute.None;

        boolean secondMatches = (secondAttribute == otherPair.getFirstAttribute() ||
                secondAttribute == otherPair.getSecondAttribute()) && secondAttribute != TypeAttribute.None;

        int firstInt = firstMatches ? 1 : 0;
        int secondInt = secondMatches ? 1 : 0;
        return firstInt + secondInt;
    }

    public TypeAttribute getFirstAttribute() { return firstAttribute; }
    public TypeAttribute getSecondAttribute() { return secondAttribute; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttributePair)) return false;
        AttributePair key = (AttributePair) o;
        return (firstAttribute == key.firstAttribute && secondAttribute == key.secondAttribute);
    }

    // TODO: this is probably a really shitty hashcode function (index zero)
    @Override
    public int hashCode() {
        TypeAttribute[] allAttributes = TypeAttribute.values();
        List<TypeAttribute> attributeList = Arrays.stream(allAttributes).toList();
        int firstIndex = attributeList.indexOf(firstAttribute);
        int secondIndex = attributeList.indexOf(secondAttribute);

        return firstIndex * firstIndex * secondIndex;
    }
}
