/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ACER
 */

import java.util.List;

public abstract class BaseController<T> {
    public abstract List<T> ambilSemua();
    public abstract T ambilBerdasarkanId(String id);
    public abstract boolean tambah(T item);
    public abstract boolean perbarui(T item);
    public abstract boolean hapus(String id);
}
