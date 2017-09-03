package com.traviatour.travianmockupkotlin;

import java.util.ArrayList;
import java.util.List;

public class SectionPromoModel {

    private String SectionTitle;
    private List<SinglePromoModel> SectionItems;


    public SectionPromoModel() {

    }
    public SectionPromoModel(String _SectionTitle, List<SinglePromoModel> _SectionItems) {
        this.SectionTitle = _SectionTitle;
        this.SectionItems = _SectionItems;
    }

    public String GetSectionTitle() {
        return SectionTitle;
    }

    public void SetSectionTitle(String headerTitle) {
        this.SectionTitle = headerTitle;
    }

    public List<SinglePromoModel> getAllItemsInSection() {
        return SectionItems;
    }

    public void setAllItemsInSection(List<SinglePromoModel> allItemsInSection) {
        this.SectionItems = allItemsInSection;
    }
}
