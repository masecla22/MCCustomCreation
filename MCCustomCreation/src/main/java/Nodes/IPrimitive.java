package Nodes;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IPrimitive<T> {

    T getValue(LivingEntity executor,ItemStack item);

}