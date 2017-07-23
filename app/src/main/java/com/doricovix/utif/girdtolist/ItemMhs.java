package com.doricovix.utif.girdtolist;

/**
 * Created by utif on 7/23/2017.
 */

public class ItemMhs {
    private String id;
    private String nm_mhs;
    private int ft_mhs;

    public ItemMhs(String nm_mhs, int ft_mhs) {
        this.nm_mhs = nm_mhs;
        this.ft_mhs = ft_mhs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNm_mhs() {
        return nm_mhs;
    }

    public void setNm_mhs(String nm_mhs) {
        this.nm_mhs = nm_mhs;
    }

    public int getFt_mhs() {
        return ft_mhs;
    }

    public void setFt_mhs(int ft_mhs) {
        this.ft_mhs = ft_mhs;
    }
}
