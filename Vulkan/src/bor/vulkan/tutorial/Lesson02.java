/**
 * 
 */
package bor.vulkan.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.jnigen.JniGenSharedLibraryLoader;

import bor.vulkan.Vk10;
import bor.vulkan.VkDevice;
import bor.vulkan.VkInstance;
import bor.vulkan.VkPhysicalDevice;
import bor.vulkan.Vulkan;
import bor.vulkan.enumerations.VkResult;
import bor.vulkan.enumerations.VkStructureType;
import bor.vulkan.khr.WSI;
import bor.vulkan.structs.VkAllocationCallbacks;
import bor.vulkan.structs.VkApplicationInfo;
import bor.vulkan.structs.VkDeviceCreateInfo;
import bor.vulkan.structs.VkDeviceQueueCreateInfo;
import bor.vulkan.structs.VkInstanceCreateInfo;
import bor.vulkan.structs.VkLayerProperties;
import bor.vulkan.structs.VkPhysicalDeviceFeatures;
import bor.vulkan.structs.VkPhysicalDeviceMemoryProperties;
import bor.vulkan.structs.VkPhysicalDeviceProperties;
import bor.vulkan.structs.VkQueueFamilyProperties;
import bor.vulkan.structs.VkStruct;

/**
 * Create VkPhysicalDevices and VkDevices
 * @author Alessandro Borges
 *
 */
public class Lesson02 {
    /**
     * Loading native libraries
     */
    static{
        new JniGenSharedLibraryLoader("libs/BorVulkan-natives.jar").load("BorVulkan");
    }
   
    private static String[] ppEnabledLayerNames = {"VK_LAYER_LUNARG_core_validation"}; 
    private static String[] otherLayerNames = {
            "VK_LAYER_GOOGLE_threading",     "VK_LAYER_LUNARG_parameter_validation",
            "VK_LAYER_LUNARG_device_limits", "VK_LAYER_LUNARG_object_tracker",
            "VK_LAYER_LUNARG_image",         "VK_LAYER_LUNARG_core_validation",
            "VK_LAYER_LUNARG_swapchain",     "VK_LAYER_GOOGLE_unique_objects"
        };
    
    private static String[] enabledLayerNames = {
            "VK_LAYER_GOOGLE_threading",
            "VK_LAYER_GOOGLE_unique_objects",
            "VK_LAYER_LUNARG_api_dump",
            "VK_LAYER_LUNARG_device_limits",
            "VK_LAYER_LUNARG_draw_state",
            "VK_LAYER_LUNARG_image",
            "VK_LAYER_LUNARG_mem_tracker",
            "VK_LAYER_LUNARG_object_tracker",
            "VK_LAYER_LUNARG_param_checker",
            "VK_LAYER_LUNARG_screenshot",
            "VK_LAYER_LUNARG_swapchain",
//             "VK_LAYER_LUNARG_vktrace",
        };
    
    private static String[] extensions = {Vulkan.VK_KHR_WIN32_SURFACE_EXTENSION_NAME, 
                                          Vulkan.VK_KHR_SURFACE_EXTENSION_NAME, 
                                          Vulkan.VK_EXT_DEBUG_REPORT_EXTENSION_NAME };
    /**
     * Create VkInstance
     * @param Vk10 - Vulkan 1.0 hub instance
     * @return a valid VkInstance or null 
     */
    public static VkInstance createVkInstance(){
        VkAllocationCallbacks pAllocator = null;        
        VkInstance[] pInstance = new VkInstance[1];   
        
        VkApplicationInfo appInfo = new VkApplicationInfo();
            appInfo.sType(VkStructureType.VK_STRUCTURE_TYPE_APPLICATION_INFO);
            appInfo.pApplicationName("BorVulkan - Lesson 01");
            appInfo.pEngineName("BorVulkan");
            appInfo.applicationVersion(1);
            appInfo.apiVersion(0);
            
            
            
        VkInstanceCreateInfo pCreateInfo = new VkInstanceCreateInfo();
            pCreateInfo.sType(VkStructureType.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO);
            pCreateInfo.pNext(null);
            pCreateInfo.flags(0);
            pCreateInfo.pApplicationInfo(appInfo);
            
            pCreateInfo.ppEnabledLayerNames(null);
           // pCreateInfo.ppEnabledExtensionNames(extensions);
        
        System.out.println("VkInstanceCreateInfo : " + pCreateInfo.toString()); 
        
        VkResult res =  Vk10.vkCreateInstance(pCreateInfo, pAllocator, pInstance);
        VkInstance instance = pInstance[0];
         
        System.out.println("VkResult for CreateInstance : " + res);
        
        if(res!=VkResult.VK_SUCCESS){
            System.err.println("Failed to get a valid VkInstance");
        }        
        return instance;        
    }
    
    /**
     * Enumerate and print Instance Layers
     * @param Vk10
     * @return list of Instance Layers
     */
    public static List<VkLayerProperties> enumerateInstaceLayers(){
        List<VkLayerProperties> pProperties = new ArrayList<VkLayerProperties>();
        VkResult res =  Vk10.vkEnumerateInstanceLayerProperties(pProperties );
        System.out.println("VkResult for Enumerate Instance Layer Properties " + res);
        System.out.println("VkLayerProperties count: " + pProperties.size());
        int count=0;
        for (VkLayerProperties prop : pProperties) {
            System.out.println("VkLayerProperties #" + count++);
            System.out.println(prop);
        }
        return pProperties;
    }
    
    public static List<VkPhysicalDevice> enumeratePhysicalDevices(VkInstance instance){
        List<VkPhysicalDevice> physicalDevicesList = new ArrayList<VkPhysicalDevice>();
        VkResult resEnumerateDevices = Vk10.vkEnumeratePhysicalDevices(instance, physicalDevicesList );
        
        System.out.println("VkResult for Enumerate Physical Devices " + resEnumerateDevices);       
        System.out.println("PhysicalDevices count: " + physicalDevicesList.size());
        
        return physicalDevicesList;
    }
   
    
    private static void printStructsSize(){
        
        for(int i= 1; i<124; i++){
            System.out.println("Struct # "+i+"  " + VkStruct.sizeOf(i));
            
        }
        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        printStructsSize();
       
       VkInstance instance = createVkInstance(); 
       
  // enumerate instance layers
       List<VkLayerProperties> instanceLayrPropss = enumerateInstaceLayers();
        
  //Step 2 - Enumerate Phisical Devices       
       List<VkPhysicalDevice> physicalDevicesList = enumeratePhysicalDevices( instance);
       
        System.out.println("PhysicalDevices Properties: ");
        int count = 0;
        for (VkPhysicalDevice physicalDevice : physicalDevicesList) {
            VkPhysicalDeviceProperties prop = new VkPhysicalDeviceProperties();
            Vk10.vkGetPhysicalDeviceProperties(physicalDevice, prop);
            System.out.println("Properties for PhysicalDevice #" + count++);
            System.out.println(prop);
            System.out.println("==============================================");
            
            System.out.println("Features for PhysicalDevice #" + count++);
            VkPhysicalDeviceFeatures features = new VkPhysicalDeviceFeatures();
            Vk10.vkGetPhysicalDeviceFeatures(physicalDevice, features);
            System.out.println(features);
            
            System.out.println("Memory for PhysicalDevice #" + count++);
            VkPhysicalDeviceMemoryProperties pMemoryProperties = new VkPhysicalDeviceMemoryProperties();
            Vk10.vkGetPhysicalDeviceMemoryProperties(physicalDevice, pMemoryProperties); 
            System.out.println(pMemoryProperties);
            
        }
        
       
        
      //Step 3 - Create a Device
        VkPhysicalDevice physicalDevice = physicalDevicesList.get(0);
        
        
        int[] pQueueFamilyPropertyCount = {1};
        List<VkQueueFamilyProperties> pQueueFamilyProperties = new ArrayList<VkQueueFamilyProperties>();
        Vk10.vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueFamilyPropertyCount, pQueueFamilyProperties);
        
        for (int i = 0; i < pQueueFamilyProperties.size(); i++) {
            VkQueueFamilyProperties queueFamily = pQueueFamilyProperties.get(i);
            System.out.println("VkQueueFamilyProperties #" + i);
            System.out.println(queueFamily);
            
        }
        
       // DEVICE 
        VkDevice[] pDevice = new VkDevice[1];
        
        VkDeviceQueueCreateInfo[] pQueueCreateInfos = new VkDeviceQueueCreateInfo[1];        
        float[] queue_priorities = {1.0f};
        VkDeviceQueueCreateInfo queueCreateInfo = new VkDeviceQueueCreateInfo();
        
        queueCreateInfo.sType(VkStructureType.VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO);
        queueCreateInfo.pNext(null);
        queueCreateInfo.flags(0);
        queueCreateInfo.queueFamilyIndex(0);
        queueCreateInfo.queueCount(1);
        queueCreateInfo.pQueuePriorities(queue_priorities);
        
        pQueueCreateInfos[0] = queueCreateInfo;
        
        VkDeviceCreateInfo pCreateDeviceInfo = new VkDeviceCreateInfo();
        pCreateDeviceInfo.dump();
        pCreateDeviceInfo.sType(VkStructureType.VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO);
        pCreateDeviceInfo.pNext(null);
        pCreateDeviceInfo.flags(0);
        pCreateDeviceInfo.queueCreateInfoCount(1);
        pCreateDeviceInfo.pQueueCreateInfos(pQueueCreateInfos);
        
        //VkDeviceQueueCreateInfo*
        pCreateDeviceInfo.pQueueCreateInfos(pQueueCreateInfos);
        pCreateDeviceInfo.dump();
        
        System.err.println("VkDeviceCreateInfo: " +  pCreateDeviceInfo);
        
        VkAllocationCallbacks pAllocator = null;
        
        VkResult resDevice = Vk10.vkCreateDevice(physicalDevice, pCreateDeviceInfo, pAllocator , pDevice );
        System.out.println("VkResult for Device Creation: " + resDevice);
        VkDevice device = pDevice[0];
        
        Vk10.vkDestroyDevice(device , pAllocator);
        Vk10.vkDestroyInstance(instance, pAllocator);
    }

}