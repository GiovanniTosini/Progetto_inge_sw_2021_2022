package backend;

public class Model {

    private static Model modelInstance;

    public Model() {
    }

    public static Model getModel(){

        if(modelInstance==null){
            modelInstance = new Model();
        }
        return modelInstance;

    }

}
