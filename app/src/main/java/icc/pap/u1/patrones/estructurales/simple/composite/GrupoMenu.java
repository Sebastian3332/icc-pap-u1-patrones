package icc.pap.u1.patrones.estructurales.simple.composite;

import java.util.ArrayList;
import java.util.List;

// Clase composite porque agrupa productos ElementoMenu
// y calcula un precio en este caso es la sumatoria de todos
// los ElementosMenu
public class GrupoMenu implements ElementoMenu {

    public GrupoMenu() {
        items = new ArrayList<>();
    }

    private List<ElementoMenu> items;

    @Override
    public double precio() {
        // la sumatoria de todos
        double suma = 0; 
        for( ElementoMenu elementosMenu : items) {
            suma = suma + elementosMenu.precio();
        }
        // return suma;

        return items.stream().mapToDouble(ElementoMenu::precio).sum();

    }

    public void addItem(ElementoMenu item) {
        this.items.add(item);
    }
}
