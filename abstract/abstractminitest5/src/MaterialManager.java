import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    private List<Material> materials = new ArrayList<>();

    public void add(Material m) {
        materials.add(m);
    }

    public void remove(String id) {
        materials.removeIf(m -> m.getId().equals(id));
    }

    public void update(String id, Material updated) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.set(i, updated);
                return;
            }
        }
    }

    public void showAll() {
        for (Material m : materials) {
            System.out.println(m.getName() + ": Amount = " + m.getAmount() + ", Discounted = " + m.getRealMoney());
        }
    }

    public double getTotalAmount() {
        return materials.stream().mapToDouble(Material::getAmount).sum();
    }

    public double getTotalDiscounted() {
        return materials.stream().mapToDouble(Material::getRealMoney).sum();
    }

    public double getDifference() {
        return getTotalAmount() - getTotalDiscounted();
    }
}
