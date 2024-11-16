package Controller;

import Database.ItemModel;
import java.util.List;

public class ItemController extends BaseController<ItemModel> {
    
    @Override
    public List<ItemModel> ambilSemua() {
        return ItemModel.ambilSemuaBarang();
    }

    @Override
    public ItemModel ambilBerdasarkanId(String id) {
        return ItemModel.ambilBarangBerdasarkanId(id);
    }

    @Override
    public boolean tambah(ItemModel item) {
        return ItemModel.tambahBarang(item);
    }

    @Override
    public boolean perbarui(ItemModel item) {
        return ItemModel.perbaruiBarang(item);
    }

    @Override
    public boolean hapus(String id) {
        return ItemModel.hapusBarang(id);
    }
}
