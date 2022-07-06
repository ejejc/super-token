package letsgetit.auth.supertoken.domain.enumtest;

public enum Robot implements SCP{
    PRINTER {

    },

    HOUSE {
    };


    @Override
    public String getEventContent() {
        return this.name();
    }
}
