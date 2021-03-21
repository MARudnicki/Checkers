import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class Controller {

    private static final Controller INSTANCE = new Controller();
    private List<Field> fields = new ArrayList<>();

    private Controller() {
    }

    public static Controller getInstance() {
        return INSTANCE;
    }

    void addField(Field field) {
        fields.add(field);
    }

    public void onClick(Field field) {
        int col = field.getCol();
        int row = field.getRow();
        System.out.println("Element clicked col=" + col + ", row=" + row);
        field.setFill(Color.CORAL);

        //find right neighbor
        int neighborCol = col+1;
        int neighborRow = row;
        Field neighborField = fields.stream()
                .filter(f -> f.getRow() == neighborRow)
                .filter(f -> f.getCol() == neighborCol)
                .findAny()
                .orElseThrow(()->new RuntimeException("neighbor not available"));
        //change neighbor color
        neighborField.setFill(Color.DARKTURQUOISE);

    }
}
