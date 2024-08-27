package pconcurrente.ejemplo22;

public class Taza {

    private String contenido = "";
    private boolean hayCafe;

    public void setHayCafe(boolean hayCafe) {
        this.hayCafe = hayCafe;
    }

    public boolean getHayCafe() {
        return hayCafe;
    }

    public String getIngredientes() {
        return contenido;
    }

    public void añadirIngrediente(String ingrediente){
        contenido += " " + ingrediente;
    }
}
