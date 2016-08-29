/**
 * 
 */
package bor.vulkan;

import java.nio.ByteBuffer;

import bor.util.BigBuffer;

/**
 * Dispatchable are Vulkan handle objects.<br>
 * In contrast with NON-Dispatchable handles, which are <b>always</b> 8 bytes long,
 * the VkHandleDispatchable has same size in bytes as native C <code><b> (void*)</b> type</code>.<br>
 * In 32bit JVM it is 4 bytes long and on 64bit JVM it is 8 bytes long.<br>
 *    
 * Current Dispatchable Handlers are the following: 
 * <li>VkInstance
 * <li>VkPhysicalDevice 
 * <li>VkDevice 
 * <li>VkQueue 
 * <li>VkCommandBuffer 
 * 
 * @author Alessandro Borges
 *
 */
public class VkHandleDispatchable 
 extends VkHandle
 implements  VkInstance, VkPhysicalDevice, VkDevice, VkCommandBuffer, VkQueue
 {
    /**
     * Dispatchable class names.
     */
    public static final String[] DISPACHABLE_HANDLE_NAMES = { "VkInstance", "VkPhysicalDevice", 
                                                              "VkDevice", "VkCommandBuffer", "VkQueue"} ;

    /**
     * 
     */
    public VkHandleDispatchable() {
        super();       
    }

    /**
     * @param nativePtr
     */
    public VkHandleDispatchable(ByteBuffer nativePtr) {
        super(nativePtr);      
    }

    /**
     * @param nativeHandle
     */
    public VkHandleDispatchable(long nativeHandle) {
        super(nativeHandle);       
    }
    
    /**
     * Return size in byte of this VkHandle
     */
    public int sizeof(){
        return Vk10.SIZE_OF_HANDLE;
    }

   /**
    * 
    * @param size
    * @return
    */
    public VkArray<VkHandleDispatchable> createVkArrayDispatchable(int size) {
        VkHandleDispatchable[] array = new VkHandleDispatchable[size];
        VkArray<VkHandleDispatchable> vkArray = new VkArrayHandle(array);
        return vkArray;
    }
    
    
    /**
     * Creates a immutable list of VkArrayHandle.
     * 
     * @param size - size of list
     * @return immutable list of VkArray handles
     */
    public static VkArrayHandle createVkArrayDispatchableStatic(int size){
        VkHandleDispatchable[] array = new VkHandleDispatchable[size];        
        VkArrayHandle<VkHandleDispatchable> vkArray = new VkArrayHandle<VkHandleDispatchable>(array);
        return vkArray;
    }

    @Override
    public VkArrayHandleDispatchable<VkInstance> createArray(int size) {
        // TODO Auto-generated method stub
        return null;
    }

      
    

}
