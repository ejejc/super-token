package letsgetit.auth.supertoken.domain.enumtest;

public enum Monster implements SCP{

    ZOMBIE,
    DRAGON,
    ;

    @Override
    public String getEventContent() {
        return this.name();
    }
}
