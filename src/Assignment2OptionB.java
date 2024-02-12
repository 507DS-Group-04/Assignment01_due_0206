import java.util.Stack;

public class Assignment2OptionB {
    public static void main(String[] args) {
        /*
        demo input
        * <div><</div>
        * */
        System.out.println(isHTMLMatched("""
                <html>
                <head>
                <title>Page Title</title>
                </head>
                <body>
                        <div></div>        
                <h1>This is a Heading</h1>
                <p>This is a paragraph.</p>
                                
                </body>
                </html>"""));
    }

    public static boolean isHTMLMatched(String html) {
        if(html == null || html.indexOf('<') < 0 || html.indexOf('>') < 0){ return false; }

        Stack<String> buffer = new Stack<>();

        for (int i = 0; i < html.length(); i++) {
            // substring valid  tag
            if(html.charAt(i) == '<') {
                int rightArrowIndex = html.indexOf('>',i);
                if(rightArrowIndex <0){
                    return false;
                }

                String tag = html.substring(i, rightArrowIndex + 1);
                // right tag: <> , wrong tag such as :<<>  <>>
                long leftArrowCount = tag.chars().filter(c -> c == '<').count();
                long rightArrowCount = tag.chars().filter(c -> c == '<').count();
                if(leftArrowCount!=1 || rightArrowCount!=1){
                    return false;
                }

                if (tag.startsWith("</")) {
                    // // find tag such as: </div>
                    System.out.println("right tag->" + tag);
                    if (buffer.isEmpty()) {
                        return false;
                    }
                    System.out.println("buffer before pop->" + buffer);
                    if (!buffer.pop().equals(tag.replace("/", ""))) {
                        return false;
                    }
                    System.out.println("buffer after pop->" + buffer);
                } else {
                    // find tag such as: <div>
                    System.out.println("left tag->" + tag);
                    buffer.push(tag);
                }
            }
        }
        return  buffer.isEmpty();
    }
}
