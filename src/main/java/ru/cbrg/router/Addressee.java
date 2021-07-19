package ru.cbrg.router;

import java.util.EnumSet;

public enum Addressee {

    MDM_1C("1c_mdm"),
    UPP_1C("1c_upp"),
    TERRASOFT("terrasoft");

    private String topic;
    public final static EnumSet<Addressee> ALL_ADDRESSEE = EnumSet.of(MDM_1C,UPP_1C,TERRASOFT);

    Addressee(String topic) {
        this.topic = topic;
    }

    public String getTopic() {return topic;}
}
