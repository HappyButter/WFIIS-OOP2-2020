public class Translation {
    private final String key;
    private final String value;

    Translation(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getTranslated(String s){
        if(s.equals(this.key))
            return this.value;
        else if(s.equals(this.value))
            return this.key;
        return null;
    }

    public boolean isPresent(String s){
        return s.equals(this.key) || s.equals(this.value);
    }

    @Override
    public String toString() {
        return key + " " + value + '\n';
    }
}
