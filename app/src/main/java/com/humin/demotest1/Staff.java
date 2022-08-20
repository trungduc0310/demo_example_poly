package com.humin.demotest1;

public class Staff {
    private int idStaff;
    private String nameStaff;
    private String birthdayStaff;
    private String onBoard;
    private int idDepartment;

    public Staff(String nameStaff, String birthdayStaff, int idDepartment) {
        this.nameStaff = nameStaff;
        this.birthdayStaff = birthdayStaff;
        this.idDepartment = idDepartment;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getBirthdayStaff() {
        return birthdayStaff;
    }

    public void setBirthdayStaff(String birthdayStaff) {
        this.birthdayStaff = birthdayStaff;
    }

    public String getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(String onBoard) {
        this.onBoard = onBoard;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
}
