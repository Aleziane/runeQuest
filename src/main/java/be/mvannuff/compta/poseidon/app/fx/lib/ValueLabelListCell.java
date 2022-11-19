package be.mvannuff.compta.poseidon.app.fx.lib;

import javafx.scene.control.ListCell;

public class ValueLabelListCell<T extends Labelized> extends ListCell<T> {

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            setText(null);
        }else {
            setText(item.getLabel());
        }
    }
}
