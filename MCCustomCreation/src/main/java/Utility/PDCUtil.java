package Utility;

import me.ODINN.MCCustomCreation.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Arrays;

/**
 * An utility class for Persistent Data Container
 */
public class PDCUtil {

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @return if the given container has the given key with the given value
     */
    public static boolean has(PersistentDataContainer container,String key,Class clazz){
        return container.has(new NamespacedKey(Main.getInstance(),key),new StoredData<>(clazz));
    }

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @return if the given container has the given key with the given value
     */
    public static boolean has(ItemStack container, String key,Class clazz){
        return has(container.getItemMeta().getPersistentDataContainer(), key,clazz);
    }

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @return if the given container has the given key with the given value
     */
    public static boolean has(LivingEntity container, String key, Class clazz){
        return has(container.getPersistentDataContainer(),key,clazz);
    }

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @return the value of the given container with the given key with the given class of return type
     */
    public static <T> T get(PersistentDataContainer container,String key,Class<T> clazz){
        if(has(container,key,clazz))
            return container.get(new NamespacedKey(Main.getInstance(),key),new StoredData<>(clazz));
        return null;
    }

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @return the value of the given container with the given key with the given class of return type
     */
    public static <T> T get(ItemStack container, String key,Class<T> clazz){
        return get(container.getItemMeta().getPersistentDataContainer(), key,clazz);
    }

    /**
     *
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @return the value of the given container with the given key with the given class of return type
     */
    public static <T> T get(LivingEntity container, String key, Class<T> clazz){
        return get(container.getPersistentDataContainer(),key,clazz);
    }

    /**
     * sets the given value in the given container with the given key with the given class of value type
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @param value a given value
     */
    public static <T> void set(PersistentDataContainer container,String key,Class<T> clazz,T value){
        container.set(new NamespacedKey(Main.getInstance(),key),new StoredData<>(clazz),value);
    }

    /**
     * sets the given value in the given container with the given key with the given class of value type
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @param value a given value
     */
    public static <T> void set(ItemStack container,String key,Class<T> clazz,T value){
        ItemMeta meta =container.getItemMeta();
        set(meta.getPersistentDataContainer(),key,clazz,value);
        container.setItemMeta(meta);
    }

    /**
     * sets the given value in the given container with the given key with the given class of value type
     * @param container a given container
     * @param key a given key
     * @param clazz a given class
     * @param <T> the container's value type
     * @param value a given value
     */
    public static <T> void set(LivingEntity container,String key,Class<T> clazz,T value){
        container.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(),key),new StoredData<>(clazz),value);
    }

}
