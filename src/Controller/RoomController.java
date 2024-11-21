/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ACER
 */

import Database.RoomModel;
import java.util.List;

public class RoomController extends BaseController<RoomModel> {
    
    @Override
    public List<RoomModel> ambilSemua() {
        return RoomModel.ambilSemuaRuangan();
    }

    @Override
    public RoomModel ambilBerdasarkanId(String id) {
        return RoomModel.ambilRuanganBerdasarkanId(id);
    }

    @Override
    public boolean tambah(RoomModel room) {
        return RoomModel.tambahRuangan(room);
    }

    @Override
    public boolean perbarui(RoomModel room) {
        return RoomModel.perbaruiRuangan(room);
    }

    @Override
    public boolean hapus(String id) {
        return RoomModel.hapusRuangan(id);
    }
}
