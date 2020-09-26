import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBodyMassIndex_constructor() {
        BodyMassIndex bmi = new BodyMassIndex(67, 150);

        assertEquals(67, bmi.height);
        assertEquals(150, bmi.weight);
    }

    @Test
    public void testBodyMassIndex_calculateScore() {
        BodyMassIndex bmi = new BodyMassIndex(67, 150);

        assertEquals(23.5, bmi.calculateScore(bmi));
    }

    @Test
    public void testBodyMassIndex_calculateMyCategory() {
        BodyMassIndex bmi = new BodyMassIndex(67, 150);

        assertEquals("Normal weight", bmi.calculateCategory(bmi));
    }

    @Test
    public void testBodyMassIndex_calculateBigCategory() {
        BodyMassIndex bmi = new BodyMassIndex(67, 175);

        assertEquals("Overweight", bmi.calculateCategory(bmi));
    }

    @Test
    public void testBodyMassIndex_calculateHugeCategory() {
        BodyMassIndex bmi = new BodyMassIndex(67, 215);

        assertEquals("Obesity", bmi.calculateCategory(bmi));
    }

    @Test
    public void testBodyMassIndex_calculateSlimCategory() {
        BodyMassIndex bmi = new BodyMassIndex(67, 110);

        assertEquals("Underweight", bmi.calculateCategory(bmi));
    }

}