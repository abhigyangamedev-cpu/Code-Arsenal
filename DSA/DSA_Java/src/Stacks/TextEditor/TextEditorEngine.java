package Stacks.TextEditor;

public class TextEditorEngine {
    private String text = "";

    private Stack undoStack = new Stack();
    private Stack redoStack = new Stack();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public class TextUtils{

        void write(String newText) {
            undoStack.push(text);
            text = text + newText;
            redoStack.clear();
        }

        void undo() {
            if (undoStack.isEmpty()) {
                System.out.println("Nothing to Undo");
                return;
            }

            redoStack.push(text);
            text = undoStack.pop();
        }

        void redo() {
            if (redoStack.isEmpty()) {
                System.out.println("Nothing to Redo");
                return;
            }

            undoStack.push(text);
            text = redoStack.pop();
        }

    }

}
