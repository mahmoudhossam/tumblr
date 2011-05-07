package tumblr;

public enum Types {

    REGULAR, PHOTO, QUOTE, LINK, CONVERSATION, VIDEO, AUDIO;

    public static Types getType(int number) {
        switch (number) {
            case 1:
                return REGULAR;
            case 2:
                return PHOTO;
            case 3:
                return QUOTE;
            case 4:
                return LINK;
            case 5:
                return CONVERSATION;
            case 6:
                return VIDEO;
            case 7:
                return AUDIO;
            default:
                return null;
        }
    }
}