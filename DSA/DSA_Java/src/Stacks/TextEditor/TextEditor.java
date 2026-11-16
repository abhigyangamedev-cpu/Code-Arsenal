package Stacks.TextEditor;

public class TextEditor {
    public static void main(String[] args){
        TextEditorEngine engine = new TextEditorEngine();

        TextEditorEngine.TextUtils editor = engine.new TextUtils();

        editor.write("Hello");
        editor.write(" World");

        editor.undo();

        System.out.println("Final Text: " + engine.getText());

        editor.redo();

        editor.write(" Java");

        System.out.println("Final Text: " + engine.getText());

        editor.undo();

        System.out.println("Final Text: " + engine.getText());
    }
}
