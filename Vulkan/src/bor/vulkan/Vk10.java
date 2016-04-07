package bor.vulkan;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;

import bor.vulkan.enumerations.VkDebugReportObjectTypeEXT;
import bor.vulkan.enumerations.VkFilter;
import bor.vulkan.enumerations.VkFormat;
import bor.vulkan.enumerations.VkImageCreateFlags;
import bor.vulkan.enumerations.VkImageLayout;
import bor.vulkan.enumerations.VkImageTiling;
import bor.vulkan.enumerations.VkImageType;
import bor.vulkan.enumerations.VkImageUsageFlags;
import bor.vulkan.enumerations.VkIndexType;
import bor.vulkan.enumerations.VkPipelineBindPoint;
import bor.vulkan.enumerations.VkPipelineStageFlagBits;
import bor.vulkan.enumerations.VkPresentModeKHR;
import bor.vulkan.enumerations.VkResult;
import bor.vulkan.enumerations.VkSampleCountFlagBits;
import bor.vulkan.enumerations.VkSubpassContents;

import bor.vulkan.khr.MirConnection;
import bor.vulkan.khr.VkDisplayKHR;
import bor.vulkan.khr.VkDisplayModeKHR;
import bor.vulkan.khr.VkSurfaceKHR;
import bor.vulkan.khr.VkSwapchainKHR;
import bor.vulkan.khr.WlDisplay;
import bor.vulkan.khr.XCBVisualID;
import bor.vulkan.khr.XCBconnection;
import bor.vulkan.khr.XlibDisplay;
import bor.vulkan.khr.XlibVisualID;

import bor.vulkan.khr.structs.VkAndroidSurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkDisplayModeCreateInfoKHR;
import bor.vulkan.khr.structs.VkDisplayModePropertiesKHR;
import bor.vulkan.khr.structs.VkDisplayPlaneCapabilitiesKHR;
import bor.vulkan.khr.structs.VkDisplayPlanePropertiesKHR;
import bor.vulkan.khr.structs.VkDisplayPropertiesKHR;
import bor.vulkan.khr.structs.VkDisplaySurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkMirSurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkPresentInfoKHR;
import bor.vulkan.khr.structs.VkSurfaceCapabilitiesKHR;
import bor.vulkan.khr.structs.VkSurfaceFormatKHR;
import bor.vulkan.khr.structs.VkSwapchainCreateInfoKHR;
import bor.vulkan.khr.structs.VkWaylandSurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkWin32SurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkXcbSurfaceCreateInfoKHR;
import bor.vulkan.khr.structs.VkXlibSurfaceCreateInfoKHR;

import bor.vulkan.structs.VkAllocationCallbacks;
import bor.vulkan.structs.VkBindSparseInfo;
import bor.vulkan.structs.VkBufferCopy;
import bor.vulkan.structs.VkBufferCreateInfo;
import bor.vulkan.structs.VkBufferImageCopy;
import bor.vulkan.structs.VkBufferMemoryBarrier;
import bor.vulkan.structs.VkBufferViewCreateInfo;
import bor.vulkan.structs.VkClearAttachment;
import bor.vulkan.structs.VkClearColorValue;
import bor.vulkan.structs.VkClearDepthStencilValue;
import bor.vulkan.structs.VkClearRect;
import bor.vulkan.structs.VkCommandBufferAllocateInfo;
import bor.vulkan.structs.VkCommandBufferBeginInfo;
import bor.vulkan.structs.VkCommandPoolCreateInfo;
import bor.vulkan.structs.VkComputePipelineCreateInfo;
import bor.vulkan.structs.VkCopyDescriptorSet;
import bor.vulkan.structs.VkDebugReportCallbackCreateInfoEXT;
import bor.vulkan.structs.VkDescriptorPoolCreateInfo;
import bor.vulkan.structs.VkDescriptorSetAllocateInfo;
import bor.vulkan.structs.VkDescriptorSetLayoutCreateInfo;
import bor.vulkan.structs.VkDeviceCreateInfo;
import bor.vulkan.structs.VkEventCreateInfo;
import bor.vulkan.structs.VkExtensionProperties;
import bor.vulkan.structs.VkExtent2D;
import bor.vulkan.structs.VkFenceCreateInfo;
import bor.vulkan.structs.VkFormatProperties;
import bor.vulkan.structs.VkFramebufferCreateInfo;
import bor.vulkan.structs.VkGraphicsPipelineCreateInfo;
import bor.vulkan.structs.VkImageBlit;
import bor.vulkan.structs.VkImageCopy;
import bor.vulkan.structs.VkImageCreateInfo;
import bor.vulkan.structs.VkImageFormatProperties;
import bor.vulkan.structs.VkImageMemoryBarrier;
import bor.vulkan.structs.VkImageResolve;
import bor.vulkan.structs.VkImageSubresource;
import bor.vulkan.structs.VkImageSubresourceRange;
import bor.vulkan.structs.VkImageViewCreateInfo;
import bor.vulkan.structs.VkInstanceCreateInfo;
import bor.vulkan.structs.VkLayerProperties;
import bor.vulkan.structs.VkMappedMemoryRange;
import bor.vulkan.structs.VkMemoryAllocateInfo;
import bor.vulkan.structs.VkMemoryBarrier;
import bor.vulkan.structs.VkMemoryRequirements;
import bor.vulkan.structs.VkPhysicalDeviceFeatures;
import bor.vulkan.structs.VkPhysicalDeviceMemoryProperties;
import bor.vulkan.structs.VkPhysicalDeviceProperties;
import bor.vulkan.structs.VkPipelineCacheCreateInfo;
import bor.vulkan.structs.VkPipelineLayoutCreateInfo;
import bor.vulkan.structs.VkQueryPoolCreateInfo;
import bor.vulkan.structs.VkQueueFamilyProperties;
import bor.vulkan.structs.VkRect2D;
import bor.vulkan.structs.VkRenderPassBeginInfo;
import bor.vulkan.structs.VkRenderPassCreateInfo;
import bor.vulkan.structs.VkSamplerCreateInfo;
import bor.vulkan.structs.VkSemaphoreCreateInfo;
import bor.vulkan.structs.VkShaderModuleCreateInfo;
import bor.vulkan.structs.VkSparseImageFormatProperties;
import bor.vulkan.structs.VkSparseImageMemoryRequirements;
import bor.vulkan.structs.VkStruct;
import bor.vulkan.structs.VkSubmitInfo;
import bor.vulkan.structs.VkSubresourceLayout;
import bor.vulkan.structs.VkViewport;
import bor.vulkan.structs.VkWriteDescriptorSet;

public class Vk10 extends Vulkan {

    /** Includes **/
    //@off
    /*JNI
      #define VK_USE_PLATFORM_WIN32_KHR 1
      
      
      #define BOR_LOADER 0
      #undef BOR_LOADER
      
      #include <vulkan/vulkan.h>      
      #include <stdio.h>
      #include <stdlib.h>
      #include <JBufferArray.h>  
      using namespace std;
      
      static jclass byteBufferClass;
      
      // Cache method IDs each time the class is loaded. 
        
      inline VkInstance deferVkInstance(unsigned char* pInstance)
      {
       VkInstance* instance = (VkInstance*)(pInstance);  
       return *instance;
      }
      
      ////////////////////////////////////////
     */
    
    private static native void init();/*
       jclass bufferClassLocal = env->FindClass("java/nio/ByteBuffer");
       byteBufferClass = (jclass) env->NewGlobalRef(bufferClassLocal);
    */
    
   /**
    * <h2>Prototype</h2>
    * 
    * <pre>
    * VKAPI_ATTR VkResult VKAPI_CALL vkCreateInstance(
    *     const VkInstanceCreateInfo*                 pCreateInfo,
    *     const VkAllocationCallbacks*                pAllocator,
    *     VkInstance*                                 pInstance);
    * </pre>
    * 
    * @param pCreateInfo -  Pointer to instance creation structure.
    * @param pAllocator - 
    * @param pInstance - Pointer to variable which will receive the new instance handle.
    * 
    */
   public VkResult vkCreateInstance(VkInstanceCreateInfo pCreateInfo,
                                    VkAllocationCallbacks pAllocator,
                                    VkInstance[] pInstance) {
       int[] result = { 0 };
       ByteBuffer pInstanceHandle = vkCreateInstance0(pCreateInfo.getPointerStruct(), 
               pAllocator.getPointerStruct(),
               result);

       if(pInstance[0]==null){
           pInstance[0] = new VkHandle(pInstanceHandle);
       }else{
           pInstance[0].setPointer(pInstanceHandle);           
       }
       return VkResult.fromValue(result[0]);
   }

  /**
   * 
   * @param pCreateInfo
   * @param pAllocator
   * @param result
   * @return
   */
   private static native ByteBuffer vkCreateInstance0(
       Buffer  pCreateInfo,
       Buffer  pAllocator,
       int[] result);/*
       
       // isolate [in][out] parameter and cast it
       jobject buff = NULL; 
       VkInstance* pInstance = nullptr;
               
       VkResult res =  vkCreateInstance(
        (const VkInstanceCreateInfo*)                 pCreateInfo,
        (const VkAllocationCallbacks*)                pAllocator,
        (VkInstance*)                                 pInstance);
                 
        // restore value for [OUT]
        result[0] = (jint) res;
        
         if(res==VK_SUCCESS){      
            buff = env->NewDirectByteBuffer((void*) pInstance, 
                                            (jlong) sizeof(void*));
         }                    
        return buff;                  
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkDestroyInstance(
        *     VkInstance                                  instance,
        *     const VkAllocationCallbacks*                pAllocator);
        * </pre>
        *  @param instance - Vulkan instance to release. 
        *  @param pAllocator - callBacks
        */
  public void vkDestroyInstance(VkInstance  instance,
                                VkAllocationCallbacks  pAllocator){
      
      vkDestroyInstance0(instance.getHandle(), 
                         pAllocator.getPointerStruct());      
  }

  /**
   * Native method
   * @param instance
   * @param pAllocator
   */
   private static native void vkDestroyInstance0(Buffer  pInstance,
                                                 Buffer  pAllocator);/*       
       
       VkInstance* instance = (VkInstance*)(pInstance);                                                         
       vkDestroyInstance( (VkInstance) (*instance),
                          (const VkAllocationCallbacks*)   pAllocator);        
       */

       /////////////////////////////////////

   /**
    * <h2>Prototype</h2>
    * 
    * <pre>
    * VKAPI_ATTR VkResult VKAPI_CALL vkEnumeratePhysicalDevices(
    *     VkInstance                                  instance,
    *     uint32_t*                                   pPhysicalDeviceCount,
    *     VkPhysicalDevice*                           pPhysicalDevices);
    * </pre>
    * 
    * @param instance -  A handle to the instance to be used to enumerate devices.
    * @param pPhysicalDeviceCount - 
    *  A pointer to a variable containing the maximum number of devices to enumerate.
    * @param pPhysicalDevices - 
    * A pointer to an array that will be filled with handles to the enumerated devices.
    * 
    * 
    */
   public VkResult vkEnumeratePhysicalDevices(VkInstance instance,
                                              int[] pPhysicalDeviceCount,
                                              VkPhysicalDevice[] pPhysicalDevices){       
       int size = 0;
       ByteBuffer[]  pPhysicalDevicesArray = null;
       
       if (pPhysicalDevices != null) {
           size = pPhysicalDevices.length;
           pPhysicalDevicesArray = new ByteBuffer[size];
           for (int i = 0; i < pPhysicalDevices.length; i++) {
               pPhysicalDevices[i] = null;
           }
       }
       //sanity check
       if(pPhysicalDeviceCount==null || pPhysicalDeviceCount.length<1){
           pPhysicalDeviceCount = new int[1];
       }
             
       int res = vkEnumeratePhysicalDevices0(instance.getHandle(),
                                              pPhysicalDeviceCount,
                                              pPhysicalDevicesArray,
                                              size);
       // prepare to return
       if (pPhysicalDevices != null) {
           for (int i = 0; i < pPhysicalDevicesArray.length; i++) {
               ByteBuffer handle = pPhysicalDevicesArray[i];
               if (handle != null) {
                   pPhysicalDevices[i] = new VkHandle(handle);
               } // if
           }// for
       }// if null
       
       VkResult ret = VkResult.fromValue(res);
       if(ret==null){
           throw new UnsupportedOperationException("VkResult is ored value:" + res);
       }
       return ret;
   }// method

   /**
    * 
    * @param instance
    * @param pPhysicalDeviceCount
    * @param pPhysicalDevicesRet
    * @param size
    * @return
    */
   private static native int vkEnumeratePhysicalDevices0(
                                       Buffer _instance,
                                       int[]   pPhysicalDeviceCount,
                                       Buffer[]  pPhysicalDevicesRet,
                                       int size);/*
       VkInstance* instance = (VkInstance*)_instance;
       VkPhysicalDevice* pPhysicalDevices = NULL;        
       if(size>0){
          pPhysicalDevices =  new VkPhysicalDevice[size];
        }     
              
       VkResult res = vkEnumeratePhysicalDevices(
                                  (VkInstance) (*instance),
                                  (uint32_t*)  pPhysicalDeviceCount,
                                  (VkPhysicalDevice*) pPhysicalDevices);
                                  
         // wrap pointers to ByteBuffer[] pPhysicalDevicesRet
         for(int i=0; i<size; i++){
               // if not null
              if(pPhysicalDevices+i){
                jobject buff =  env->NewDirectByteBuffer((void*) (pPhysicalDevices+i), 
                                                         (jlong) sizeof(void*));               
                if(buff)
                     env->SetObjectArrayElement(pPhysicalDevicesRet, i, buff);
              }
         }
         // clean up    
         if(pPhysicalDevices)
              delete pPhysicalDevices; 
         
         return (jint) res;
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFeatures(
        *     VkPhysicalDevice                            physicalDevice,
        *     VkPhysicalDeviceFeatures*                   pFeatures);
        * </pre>
        */
  public  void vkGetPhysicalDeviceFeatures(VkPhysicalDevice  physicalDevice,
                                           VkPhysicalDeviceFeatures  pFeatures){
      vkGetPhysicalDeviceFeatures0( physicalDevice.getHandle(),
                                    pFeatures.getPointerStruct());      
  }

   private static native void vkGetPhysicalDeviceFeatures0(Buffer  pphysicalDevice,
                                                           Buffer  pFeatures);/*
                                                           
    VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;
                                                           
    vkGetPhysicalDeviceFeatures(
               (VkPhysicalDevice)  (*physicalDevice),
               (VkPhysicalDeviceFeatures*)  pFeatures);
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceFormatProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     VkFormat                                    format,
        *     VkFormatProperties*                         pFormatProperties);
        * </pre>
        * @param  physicalDevice - A handle to the physical device to query. 
        * @param format -  The format whose properties to query. 
        * @param pFormatProperties- A pointer to the structure to
        *  receive the result of the query. . 
        * 
        */
   public void vkGetPhysicalDeviceFormatProperties(VkPhysicalDevice physicalDevice,
                                                   VkFormat format,
                                                   VkFormatProperties pFormatProperties) {
       vkGetPhysicalDeviceFormatProperties0( physicalDevice.getHandle(),
                                             format.getValue(),
                                             pFormatProperties.getPointerStruct());
      }

   private static native void vkGetPhysicalDeviceFormatProperties0(
               Buffer  pphysicalDevice,
               int  format,
               Buffer  pFormatProperties);/*
               
     VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;          
     vkGetPhysicalDeviceFormatProperties(
              (VkPhysicalDevice)  (*physicalDevice),
              (VkFormat)  format,
              (VkFormatProperties*)   pFormatProperties);
    */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR VkResult VKAPI_CALL vkGetPhysicalDeviceImageFormatProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     VkFormat                                    format,
        *     VkImageType                                 type,
        *     VkImageTiling                               tiling,
        *     VkImageUsageFlags                           usage,
        *     VkImageCreateFlags                          flags,
        *     VkImageFormatProperties*                    pImageFormatProperties);
        * </pre>
        */
  public  VkResult vkGetPhysicalDeviceImageFormatProperties(
               VkPhysicalDevice  physicalDevice,
               VkFormat  format,
               VkImageType  type,
               VkImageTiling  tiling,
               VkImageUsageFlags  usage,
               VkImageCreateFlags  flags,
               VkImageFormatProperties  pImageFormatProperties){
      
    int res =  vkGetPhysicalDeviceImageFormatProperties0(
             /*VkPhysicalDevice*/  physicalDevice.getHandle(),
             /* VkFormat*/     format.getValue(),
             /* VkImageType*/  type.getValue(),
             /* VkImageTiling*/  tiling.getValue(),
             /* VkImageUsageFlags*/  usage.getValue(),
             /* VkImageCreateFlags*/  flags.getValue(),
             /* VkImageFormatProperties*/  pImageFormatProperties.getPointerStruct()
              );
    
    return VkResult.fromValue(res);       
  }
  
  
   /**
    * Native call
    * 
    * @param physicalDevice
    * @param format
    * @param type
    * @param tiling
    * @param usage
    * @param flags
    * @param pImageFormatProperties
    * @return VkResult
    */
   private static native int vkGetPhysicalDeviceImageFormatProperties0(
               Buffer  pphysicalDevice,
               int  format,
               int  type,
               int  tiling,
               int  usage,
               int  flags,
               Buffer  pImageFormatProperties);/*
               
         VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;
         VkResult res = 
         vkGetPhysicalDeviceImageFormatProperties(
               (VkPhysicalDevice) physicalDevice,
               (VkFormat)    format,
               (VkImageType) type,
               (VkImageTiling) tiling,
               (VkImageUsageFlags)  usage,
               (VkImageCreateFlags)  flags,
               (VkImageFormatProperties*) pImageFormatProperties);
               
         return (jint) res; 
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     VkPhysicalDeviceProperties*                 pProperties);
        * </pre>
        */
  public  void vkGetPhysicalDeviceProperties(
               VkPhysicalDevice  physicalDevice,
               VkPhysicalDeviceProperties  pProperties){
      
      vkGetPhysicalDeviceProperties0(
              physicalDevice.getHandle(),
              pProperties.getPointerStruct()
              );
      
  }

  /**
   * 
   * @param physicalDevice
   * @param pProperties
   */
   private static native void vkGetPhysicalDeviceProperties0(
               Buffer  pphysicalDevice,
               Buffer  pProperties);/* 
               
       VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;
               
       vkGetPhysicalDeviceProperties(
            (VkPhysicalDevice)   (*physicalDevice),
            (VkPhysicalDeviceProperties*)  pProperties);               
      */

       /////////////////////////////////////

    /**
     * <h2>Prototype</h2>
     * 
     * <pre>
     * VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceQueueFamilyProperties(
     *     VkPhysicalDevice                            physicalDevice,
     *     uint32_t*                                   pQueueFamilyPropertyCount,
     *     VkQueueFamilyProperties*                    pQueueFamilyProperties);
     * </pre>
     * 
     * 
     * @param physicalDevice - Physical device to query.
     * @param pQueueFamilyPropertyCount - Count indicating number of VkQueueFamilyProperties pointed to by
     * pQueueFamilyProperties.
     * @param pQueueFamilyProperties - Pointer to an array of VkQueueFamilyProperties structures receiving the information
     * about each particular queue family.
     * 
     * 
     * 
     */
  public  void vkGetPhysicalDeviceQueueFamilyProperties(
               VkPhysicalDevice  physicalDevice,
               int[]  pQueueFamilyPropertyCount,
               List<VkQueueFamilyProperties>  pQueueFamilyProperties){
     
     if(pQueueFamilyPropertyCount==null){
         pQueueFamilyPropertyCount = new int[1];  
     }
     ByteBuffer[] array =  vkGetPhysicalDeviceQueueFamilyProperties0(
                                   physicalDevice.getHandle(),
                                   pQueueFamilyPropertyCount);
     
     if(array != null && pQueueFamilyProperties != null ){
         pQueueFamilyProperties.clear();
         for (ByteBuffer nativeBuffer : array) {
             VkQueueFamilyProperties qfp = new VkQueueFamilyProperties(nativeBuffer);
             pQueueFamilyProperties.add(qfp);
        }
     }
  }

  /**
   * 
   * @param physicalDevice
   * @param pQueueFamilyPropertyCount
   * @return pQueueFamilyProperties as List of VkQueueFamilyProperties
   */
   private static native ByteBuffer[] vkGetPhysicalDeviceQueueFamilyProperties0(
               Buffer  pphysicalDevice,
               int[]  pQueueFamilyPropertyCount);/*                              
     VkQueueFamilyProperties*  pQueueFamilyProperties = nullptr;
     VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;
                            
     vkGetPhysicalDeviceQueueFamilyProperties(
             (VkPhysicalDevice) (*physicalDevice),
             (uint32_t*)  pQueueFamilyPropertyCount,
             (VkQueueFamilyProperties*)  pQueueFamilyProperties);
             
         if(pQueueFamilyProperties)
         {
           int length = pQueueFamilyPropertyCount[0];
           jobjectArray bufArray = 
                        (jobjectArray) env->NewObjectArray(length, byteBufferClass, NULL);
                        
           for(int i=0; i<length; i++){
              VkQueueFamilyProperties* qfp = pQueueFamilyProperties+i;
              jobject pObj = env->NewDirectByteBuffer((void*) qfp, 
                                  (jlong) sizeof(VkQueueFamilyProperties));
              env->SetObjectArrayElement(bufArray,(jsize)i, pObj);                                          
            }
            return bufArray;
         }   
         else
          return NULL;               
      */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkGetPhysicalDeviceMemoryProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     VkPhysicalDeviceMemoryProperties*           pMemoryProperties);
        * </pre>
        */
  public void vkGetPhysicalDeviceMemoryProperties(
               VkPhysicalDevice  physicalDevice,
               VkPhysicalDeviceMemoryProperties  pMemoryProperties){
      // call native method
      vkGetPhysicalDeviceMemoryProperties0(physicalDevice.getHandle(),
                                            pMemoryProperties.getPointerStruct());
  }

  /**
   * 
   * @param physicalDevice
   * @param pMemoryProperties
   */
   private static native void vkGetPhysicalDeviceMemoryProperties0(
               Buffer  pphysicalDevice,
               Buffer  pMemoryProperties);/*
               
     VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pphysicalDevice;
     vkGetPhysicalDeviceMemoryProperties(
             (VkPhysicalDevice) (*physicalDevice),
             (VkPhysicalDeviceMemoryProperties*)  pMemoryProperties);        
               
    */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetInstanceProcAddr(
        *     VkInstance                                  instance,
        *     const char*                                 pName);
        * </pre>
        */
  public PFNvkVoidFunction vkGetInstanceProcAddr(
               VkInstance  instance,
               String  pName){
      ByteBuffer pFunc = vkGetInstanceProcAddr0(instance.getHandle(),pName);
      PFNvkVoidFunction func = new PFNvkVoidFunction(pFunc);
      return func;       
  }

   private static native ByteBuffer vkGetInstanceProcAddr0(
               Buffer  pInstance,
               String  pName);/*
               VkInstance* instance = (VkInstance*)(pInstance); 
               PFN_vkVoidFunction func;               
               func  = vkGetInstanceProcAddr(
                            (VkInstance)   (*instance),
                            (const char*)     pName);                            
              jobject pFunc = env->NewDirectByteBuffer((void*) func, 
                                                      (jlong) sizeof(void*));                                                       
              return pFunc;                                                                               
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR PFN_vkVoidFunction VKAPI_CALL vkGetDeviceProcAddr(
        *     VkDevice                                    device,
        *     const char*                                 pName);
        * </pre>
        */
  public PFNvkVoidFunction vkGetDeviceProcAddr(
               VkDevice  device,
               String  pName){
      
     ByteBuffer nativeHandle =  vkGetDeviceProcAddr0(device.getHandle(), pName);     
     PFNvkVoidFunction pfn = new PFNvkVoidFunction(nativeHandle);
     return pfn;      
  }

   private static native ByteBuffer vkGetDeviceProcAddr0(
               Buffer  pDevice,
               String pName);/*
       VkDevice* device = (VkDevice*) pDevice;        
       PFN_vkVoidFunction func =  vkGetDeviceProcAddr(
                                     (VkDevice) (*device),
                                     (const char*) pName);
                               
       jobject pFunc = env->NewDirectByteBuffer((void*) func, 
                                                (jlong) sizeof(void*));                                                       
        return pFunc;
      */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR VkResult VKAPI_CALL vkCreateDevice(
        *     VkPhysicalDevice                            physicalDevice,
        *     const VkDeviceCreateInfo*                   pCreateInfo,
        *     const VkAllocationCallbacks*                pAllocator,
        *     VkDevice*                                   pDevice);
        * </pre>
        */
  public VkResult vkCreateDevice(
               VkPhysicalDevice  physicalDevice,
               VkDeviceCreateInfo  pCreateInfo,
               VkAllocationCallbacks  pAllocator,
               VkDevice[]  pDevice){
      
   if(pDevice==null || pDevice.length<1){
       throw new IllegalArgumentException("pDevice[] must be not null and length >=1");
   }  
   int[] result = {0};   
   ByteBuffer nativeHandle =   vkCreateDevice0(
               /*VkPhysicalDevice*/  physicalDevice.getHandle(),
               /*VkDeviceCreateInfo*/  pCreateInfo.getPointerStruct(),
               /*VkAllocationCallbacks*/  pAllocator.getPointerStruct(),
               /*VkDevice*/  result);
   VkDevice device = new VkHandle(nativeHandle);
   pDevice[0] = device;
   VkResult res = VkResult.fromValue(result[0]);   
   return res;   
  }

  /**
   * 
   * @param physicalDevice
   * @param pCreateInfo
   * @param pAllocator
   * @param pDevice
   * @return
   */
   private static native ByteBuffer vkCreateDevice0(
               Buffer  pPhysicalDevice,
               Buffer  pCreateInfo,
               Buffer  pAllocator,
               int[] result);/*
       
       VkDevice* pDevice = nullptr;
       VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pPhysicalDevice;
        
       VkResult res =  vkCreateDevice(
             (VkPhysicalDevice) (*physicalDevice),
             (const VkDeviceCreateInfo*)     pCreateInfo,
             (const VkAllocationCallbacks*)  pAllocator,
             (VkDevice*)                     pDevice);
         
         result[0] = res;         
         jobject pObj = env->NewDirectByteBuffer((void*) pDevice, 
                          (jlong) sizeof(void*)); 
               
         return pObj;      
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkDestroyDevice(
        *     VkDevice                                    device,
        *     const VkAllocationCallbacks*                pAllocator);
        * </pre>
        */
  public void vkDestroyDevice(
               VkDevice  device,
               VkAllocationCallbacks  pAllocator){
      vkDestroyDevice0( device.getHandle(),
                        pAllocator.getPointerStruct());
      
  }

  /**
   * 
   * @param device
   * @param pAllocator
   */
   private static native void vkDestroyDevice0(
               Buffer  pDevice,
               Buffer  pAllocator);/*
         VkDevice* device = (VkDevice*) pDevice;      
         vkDestroyDevice( (VkDevice) (*device),
                          (const VkAllocationCallbacks*)   pAllocator);
      */

       /////////////////////////////////////

    /**
     * <h2>Prototype</h2>
     * 
     * <pre>
     * VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceExtensionProperties(
     *     const char*                                 pLayerName,
     *     uint32_t*                                   pPropertyCount,
     *     VkExtensionProperties*                      pProperties);
     * </pre>
     * 
     * @param pLayerName - is either NULL or a pointer to a null-terminated UTF-8 string
     *        naming the instance layer to retrieve extensions from.
     * @param pPropertyCount - is a pointer to an integer related to the number of extension
     *        properties available or queried, as described below.
     * @param pProperties -  is either NULL or a pointer to an array of VkExtensionProperties
     *        structures.
     * 
     */
  public VkResult vkEnumerateInstanceExtensionProperties(
               String pLayerName,
               int[]  pPropertyCount,
               List<VkExtensionProperties>  pProperties){
      
      int[] result = {0};
      ByteBuffer[] props = vkEnumerateInstanceExtensionProperties0(pLayerName,
              pPropertyCount,
              result );
      
        if (pProperties != null) {
            pProperties.clear();
            if (props != null) {
                for (ByteBuffer nativeBuff : props) {
                    if (nativeBuff != null) {
                        VkExtensionProperties ep = new VkExtensionProperties(nativeBuff);
                        pProperties.add(ep);
                    }
                }
            }
        }
      return VkResult.fromValue(result[0]);
  }

   private static native ByteBuffer[] vkEnumerateInstanceExtensionProperties0(
               String  pLayerName,
               int[]  pPropertyCount,
               int[] result);/*
       
     VkExtensionProperties* pProperties = nullptr;
               
     VkResult res =vkEnumerateInstanceExtensionProperties(
                        (const char*)  pLayerName,
                        (uint32_t*)    pPropertyCount,
                        (VkExtensionProperties*) pProperties);
      
      result[0] = res;
           
      if(pProperties)
         {
           int length = pPropertyCount[0];
           jobjectArray bufArray = 
                (jobjectArray) env->NewObjectArray(length, byteBufferClass, NULL);
                        
           for(int i=0; i<length; i++){
              VkExtensionProperties* prop = pProperties+i;
              jobject pObj = env->NewDirectByteBuffer((void*) prop, 
                                   (jlong) sizeof(VkExtensionProperties)); 
              env->SetObjectArrayElement( bufArray,(jsize)i, pObj);                     
            }
            return bufArray;
         }   
         else
          return NULL;               
               
         */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceExtensionProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     const char*                                 pLayerName,
        *     uint32_t*                                   pPropertyCount,
        *     VkExtensionProperties*                      pProperties);
        * </pre>
        * 
        * @param physicalDevice -    Physical device to query.
        * @param pLayerName - Optional layer name to query.
        * @param pPropertyCount -  Count indicating number of 
        * VkExtensionProperties pointed to by pProperties.
        * @param pProperties - Pointer to an array of VkExtensionProperties.
        * 
        * 
        */
  public  VkResult vkEnumerateDeviceExtensionProperties(
               VkPhysicalDevice  physicalDevice,
               String  pLayerName,
               int[]  pPropertyCount,
               List<VkExtensionProperties>  pProperties){
      
      int[] result = {0};
      if(pPropertyCount==null){
          pPropertyCount = new int[1];
      }
      ByteBuffer[] handles = vkEnumerateDeviceExtensionProperties0(
              physicalDevice.getHandle(),
              pLayerName,
              pPropertyCount,
              result);
      
      if(pProperties != null){
          pProperties.clear();
          for (ByteBuffer nativeHand : handles) {
            if(nativeHand != null){
                VkExtensionProperties prop = new VkExtensionProperties(nativeHand);
                pProperties.add(prop);
            }
        }
      }
      
      int res = result[0];
      return VkResult.fromValue(res);
  }

   private static native ByteBuffer[] vkEnumerateDeviceExtensionProperties0(
               Buffer  pPhysicalDevice,
               String  pLayerName,
               int[]  pPropertyCount,
               int[] result);/*
               
     VkExtensionProperties*  pProperties = nullptr;
     VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pPhysicalDevice;
               
     VkResult res =  vkEnumerateDeviceExtensionProperties(
                  (VkPhysicalDevice) (*physicalDevice),
                  (const char*)    pLayerName,
                  (uint32_t*)     pPropertyCount,
                  (VkExtensionProperties*)  pProperties); 
     result[0] = res;
               
     if(pProperties){
        int length = pPropertyCount[0];
        jobjectArray bufArray = 
             (jobjectArray) env->NewObjectArray( length, 
                                                 byteBufferClass, 
                                                 NULL);                                               
        for(int i=0; i<length; i++){
            VkExtensionProperties* prop = pProperties+i;
            if(prop){
               jobject pObj = env->NewDirectByteBuffer((void*) prop, 
                                   (jlong) sizeof(VkExtensionProperties));                   
               env->SetObjectArrayElement( bufArray,(jsize)i, pObj);
            } //if 
         }//for
         return bufArray;
      }
      else
       return NULL;
               
       */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateInstanceLayerProperties(
        *     uint32_t*                                   pPropertyCount,
        *     VkLayerProperties*                          pProperties);
        * </pre>
        * 
        * @param pPropertyCount -  Pointer to count indicating 
        * space available on input and structures returned on output.
        * @param pProperties - Pointer to a array to receive the results.
        * 
        * @return VkResult
        */
  public VkResult vkEnumerateInstanceLayerProperties(
               int[]  pPropertyCount,
               List<VkLayerProperties>  pProperties){
      
      int[] result = {0};
      if(pPropertyCount==null){
          pPropertyCount = new int[1];
      }
      ByteBuffer[] nativeHandlers = vkEnumerateInstanceLayerProperties0(
              pPropertyCount,
              result);
      if(pProperties != null){
          pProperties.clear();
          for (ByteBuffer buff : nativeHandlers) {
              if(buff !=null ){
                  VkLayerProperties prop = new VkLayerProperties(buff);
                  pProperties.add(prop);
              }
        } 
      }// if
      
      return VkResult.fromValue(result[0]);
  }

   private static native ByteBuffer[] vkEnumerateInstanceLayerProperties0(
               int[]  pPropertyCount,              
               int[] result);/*
               
               VkLayerProperties*  pProperties = nullptr;
               
               VkResult res =  vkEnumerateInstanceLayerProperties(
                                 (uint32_t*) pPropertyCount,
                                 (VkLayerProperties*)  pProperties);
               
               result[0] = res;
               
               if(pProperties){
                int len = (int)pPropertyCount[0];
                jobjectArray bufArray = 
                        (jobjectArray) env->NewObjectArray(len, byteBufferClass, NULL);
                for(int i=0; i<len; i++){
                   VkLayerProperties* prop = pProperties+i;
                   if(prop){
                       jobject pObj = env->NewDirectByteBuffer((void*) prop, 
                                         (jlong) sizeof(VkLayerProperties));
                       env->SetObjectArrayElement(bufArray,(jsize)i, pObj);
                   }                     
                }
                return bufArray;
               }else
               return NULL;
        */

       /////////////////////////////////////

       /**
        * vkEnumerateDeviceLayerProperties - Returns properties of 
        * available physical device layers.
        * 
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR VkResult VKAPI_CALL vkEnumerateDeviceLayerProperties(
        *     VkPhysicalDevice                            physicalDevice,
        *     uint32_t*                                   pPropertyCount,
        *     VkLayerProperties*                          pProperties);
        * </pre>
        * 
        * @param physicalDevice - Physical device to query.
        * @param pPropertyCount -   Count indicating number of VkLayerProperties
        *  pointed to by pProperties.
        * @param pProperties - Pointer to an array of VkLayerProperties.
        * 
        * @return VkResult
        */
  public  VkResult vkEnumerateDeviceLayerProperties(
               VkPhysicalDevice  physicalDevice,
               int[]  pPropertyCount,
               List<VkLayerProperties>  pProperties){
      int[] result = {0};
      if(pPropertyCount==null){
          pPropertyCount = new int[1];
      }
      ByteBuffer[] nativeHandlers = vkEnumerateDeviceLayerProperties0(
                                          physicalDevice.getHandle(),
                                          pPropertyCount,
                                          result);
      if(pProperties != null){
          pProperties.clear();
          for (ByteBuffer buff : nativeHandlers) {
              if(buff !=null ){
                  VkLayerProperties prop = new VkLayerProperties(buff);
                  pProperties.add(prop);
              }
        } 
      }// if
      
      return VkResult.fromValue(result[0]);
  }

   private static native ByteBuffer[] vkEnumerateDeviceLayerProperties0(
               Buffer  pPhysicalDevice,
               int[]  pPropertyCount,               
               int[] result);/*
               
       VkLayerProperties*  pProperties = nullptr;
       VkPhysicalDevice* physicalDevice = (VkPhysicalDevice*)pPhysicalDevice;
                      
       VkResult res =   vkEnumerateDeviceLayerProperties(
                                  (VkPhysicalDevice)  (*physicalDevice),
                                  (uint32_t*)  pPropertyCount,
                                  (VkLayerProperties*) pProperties); 
                                                                                
       result[0] = res;
       if(pProperties){
          int len = (int)pPropertyCount[0];
          jobjectArray bufArray = 
                  (jobjectArray) env->NewObjectArray(len, byteBufferClass, NULL);
          for(int i=0; i<len; i++){
              VkLayerProperties* prop = pProperties+i;
              if(prop){
                 jobject pObj = env->NewDirectByteBuffer((void*) prop, 
                                         (jlong) sizeof(VkLayerProperties));
                  env->SetObjectArrayElement( bufArray,(jsize)i, pObj);
               }                     
           }
           return bufArray;
         }else
           return NULL;
      */

       /////////////////////////////////////

       /**
        * <h2>Prototype</h2><pre>
        * VKAPI_ATTR void VKAPI_CALL vkGetDeviceQueue(
        *     VkDevice                                    device,
        *     uint32_t                                    queueFamilyIndex,
        *     uint32_t                                    queueIndex,
        *     VkQueue*                                    pQueue);
        * </pre>
        * 
        * @param device -  Handle to the device that is the owner of the queue.
        * @param queueFamilyIndex -   The family index of the queue within the device.
        * @param queueIndex - The index of the queue within the queue family.
        * 
        * @return pQueue -   A pointer to a variable that is to receive the resulting handle.
        */
  public  VkQueue vkGetDeviceQueue(
               VkDevice  device,
               int  queueFamilyIndex,
               int  queueIndex){
      
      ByteBuffer nativeHandle = vkGetDeviceQueue0(device.getHandle(),
                                queueFamilyIndex,
                                queueIndex);
      VkQueue q = new VkHandle(nativeHandle);
      return q;
  }

  /**
   * 
   * @param device
   * @param queueFamilyIndex
   * @param queueIndex
   * @return native handle to 
   */
   private static native ByteBuffer vkGetDeviceQueue0(
               Buffer  pDevice,
               int  queueFamilyIndex,
               int  queueIndex);/*
               
       VkQueue*   pQueue = NULL;
       VkDevice* device = (VkDevice*) pDevice;
       
       VKAPI_CALL vkGetDeviceQueue(
                  (VkDevice)   (*device),
                  (uint32_t)   queueFamilyIndex,
                  (uint32_t)   queueIndex,
                  (VkQueue*)   pQueue);
       
          return  env->NewDirectByteBuffer((void*) pQueue, 
                                           (jlong) sizeof(void*));        
                  
      */

   /**
    *  Vulkan procedure ID: 19
    * <h2>Prototype</h2><pre>
    * VKAPI_ATTR VkResult VKAPI_CALL vkQueueSubmit(
    *     VkQueue                                     queue,
    *     uint32_t                                    submitCount,
    *     const VkSubmitInfo*                         pSubmits,
    *     VkFence                                     fence);
    * </pre>
    * 
    * @param queue - 
    * @param submitCount - 
    * @param pSubmits - 
    * @param fence - 
    */
public VkResult vkQueueSubmit(
           VkQueue queue,
           int submitCount,
           VkSubmitInfo  pSubmits,
           VkFence fence){
    int res =  vkQueueSubmit0(queue.getHandle(),
                       submitCount,
                       pSubmits.getPointerStruct(),
                       fence.getHandle());
    
    return VkResult.fromValue(res);
}

   /**
    *  native interface 19
    * 
    * @param queue - 
    * @param submitCount - 
    * @param pSubmits - 
    * @param fence - 
    */
private static native int vkQueueSubmit0(
           java.nio.ByteBuffer   _queue,
           int  submitCount,
           java.nio.ByteBuffer   pSubmits,
           java.nio.ByteBuffer   _fence);/*
    
       VkQueue* queue = (VkQueue*)_queue;
       VkFence* fence = (VkFence*)_fence;
       
       VkResult res = vkQueueSubmit(
                                (VkQueue)   (*queue),
                                (uint32_t)  submitCount,
                                (const VkSubmitInfo*)  pSubmits,
                                (VkFence) fence);                                
       return (jint) res;
     */


/**
 *  Vulkan procedure ID: 20
 * <h2>Prototype</h2><pre>
 *  VkResult  vkQueueWaitIdle(
 *     VkQueue                                     queue);
 * </pre>
 * 
 * @param queue - 
 * 
 * @return VkResult
 */
public VkResult vkQueueWaitIdle(
             VkQueue queue){
     int  _val = vkQueueWaitIdle0(
                     (queue==null ? null : queue.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #20
 *  vkQueueWaitIdle 
 * 
 * @param queue - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkQueueWaitIdle0(
             java.nio.ByteBuffer   queue);/* 
     VkQueue* ptr_queue = (VkQueue*) queue;
     VkResult res = vkQueueWaitIdle(
                     (VkQueue) (*ptr_queue));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 21
 * <h2>Prototype</h2><pre>
 *  VkResult  vkDeviceWaitIdle(
 *     VkDevice                                    device);
 * </pre>
 * 
 * @param device - 
 * 
 * @return VkResult
 */
public VkResult vkDeviceWaitIdle(
             VkDevice device){
     int  _val = vkDeviceWaitIdle0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #21
 *  vkDeviceWaitIdle 
 * 
 * @param device - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkDeviceWaitIdle0(
             java.nio.ByteBuffer   device);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkDeviceWaitIdle(
                     (VkDevice) (*ptr_device));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 22
 * <h2>Prototype</h2><pre>
 *  VkResult  vkAllocateMemory(
 *     VkDevice                                    device,
 *     const VkMemoryAllocateInfo*                 pAllocateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkDeviceMemory*                             pMemory);
 * </pre>
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pAllocator - 
 * @param pMemory - 
 * 
 * @return VkResult
 */
public VkResult vkAllocateMemory(
             VkDevice device,
              VkMemoryAllocateInfo  pAllocateInfo,
              VkAllocationCallbacks  pAllocator,
              VkDeviceMemory  pMemory){
     int  _val = vkAllocateMemory0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pAllocateInfo==null ? null : pAllocateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pMemory==null ? null : pMemory.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #22
 *  vkAllocateMemory 
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pAllocator - 
 * @param pMemory - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkAllocateMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pAllocateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pMemory);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkAllocateMemory(
                     (VkDevice) (*ptr_device),
                     (const VkMemoryAllocateInfo*) pAllocateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkDeviceMemory*) pMemory);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 23
 * <h2>Prototype</h2><pre>
 *  void  vkFreeMemory(
 *     VkDevice                                    device,
 *     VkDeviceMemory                              memory,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param memory - 
 * @param pAllocator - 
 */
public void vkFreeMemory(
             VkDevice device,
             VkDeviceMemory memory,
              VkAllocationCallbacks  pAllocator){
     vkFreeMemory0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (memory==null ? null : memory.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #23
 *  vkFreeMemory 
 * 
 * @param device - 
 * @param memory - 
 * @param pAllocator - 
 */
 private static native void vkFreeMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   memory,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     vkFreeMemory(
                     (VkDevice) (*ptr_device),
                     (VkDeviceMemory) (*ptr_memory),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 24
 * <h2>Prototype</h2><pre>
 *  VkResult  vkMapMemory(
 *     VkDevice                                    device,
 *     VkDeviceMemory                              memory,
 *     VkDeviceSize                                offset,
 *     VkDeviceSize                                size,
 *     VkMemoryMapFlags                            flags,
 *     void**                                      ppData);
 * </pre>
 * 
 * @param device - 
 * @param memory - 
 * @param offset - 
 * @param size - 
 * @param flags - 
 * @param ppData - 
 * 
 * @return VkResult
 */
public VkResult vkMapMemory(
             VkDevice device,
             VkDeviceMemory memory,
             long offset,
             long size,
             int flags,
             ByteBuffer[] ppData){
     //FIXED
     int[] result = {0};
     
     ByteBuffer pData = vkMapMemory0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (memory==null ? null : memory.getHandle()) /* ByteBuffer */ ,
                     offset ,
                     size ,
                     flags ,
                     result);     
      ppData[0] = pData;
      return VkResult.fromValue(result[0]);
} 

/**
 *  Native interface for Vulkan method #24
 *  vkMapMemory 
 * 
 * @param device - 
 * @param memory - 
 * @param offset - 
 * @param size - 
 * @param flags - 
 * @param ppData - 
 * 
 * @return VkResult as int  
 */
 private static native java.nio.ByteBuffer vkMapMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   memory,
             long  offset,
             long  size,
             int  flags,
             int[] result);/* 
     // FIXED        
     VkDevice* ptr_device = (VkDevice*) device;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     void* pData = nullptr;
     jobject buff = NULL;
     
     VkResult res = vkMapMemory(
                     (VkDevice) (*ptr_device),
                     (VkDeviceMemory) (*ptr_memory),
                     (VkDeviceSize) offset,
                     (VkDeviceSize) size,
                     (VkMemoryMapFlags) flags,
                     (void**) &pData);
                     
      result[0] = (jint) res; 
                    
      if(pData){
         buff = env->NewDirectByteBuffer((void*) pData, 
                                         (jlong) size); 
      }           
      return buff;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 25
 * <h2>Prototype</h2><pre>
 *  void  vkUnmapMemory(
 *     VkDevice                                    device,
 *     VkDeviceMemory                              memory);
 * </pre>
 * 
 * @param device - 
 * @param memory - 
 */
public void vkUnmapMemory(
             VkDevice device,
             VkDeviceMemory memory){
     vkUnmapMemory0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (memory==null ? null : memory.getHandle()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #25
 *  vkUnmapMemory 
 * 
 * @param device - 
 * @param memory - 
 */
 private static native void vkUnmapMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   memory);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     vkUnmapMemory(
                     (VkDevice) (*ptr_device),
                     (VkDeviceMemory) (*ptr_memory));

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 26
 * <h2>Prototype</h2><pre>
 *  VkResult  vkFlushMappedMemoryRanges(
 *     VkDevice                                    device,
 *     uint32_t                                    memoryRangeCount,
 *     const VkMappedMemoryRange*                  pMemoryRanges);
 * </pre>
 * 
 * @param device - 
 * @param memoryRangeCount - 
 * @param pMemoryRanges - 
 * 
 * @return VkResult
 */
public VkResult vkFlushMappedMemoryRanges(
             VkDevice device,
             int memoryRangeCount,
             VkMappedMemoryRange[]  pMemoryRanges){
     //FIXING -     
     ByteBuffer[] pMemoryRangesBuffers = getBuffers(pMemoryRanges, memoryRangeCount);
     int  _val = vkFlushMappedMemoryRanges0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     pMemoryRangesBuffers.length,
                     pMemoryRangesBuffers);
     
     setBuffers(pMemoryRanges, pMemoryRangesBuffers);
     return VkResult.fromValue(_val);
} 

/**
 * Set new buffer to VkStruct or VkHandkers.
 * @param vkObjArray - array of Structs
 * @param buffers - array of buffers to set
 */
 private static void setBuffers(VkObject[] vkObjArray, ByteBuffer[] buffers){
     int len = Math.min(vkObjArray.length, buffers.length);
     for(int i=0; i<len; i++){
         VkObject stru = vkObjArray[i];
         if(stru != null){
             stru.setPointer(buffers[i]);
         }
     }
 }
 
 /**
  * Get native buffers from VkObject array
  * @param vkObjArray - array of VkStructs or VkHandlers to extract buffers
  * @param max - max number of buffers to read.
  * @return array of Bytebuffers 
  */
 private static ByteBuffer[] getBuffers(VkObject[] vkObjArray, int max){
     int len = Math.min(max,vkObjArray.length);
     ByteBuffer[] buffers = new ByteBuffer[len];     
     for(int i=0; i<len; i++){
        buffers[i] = (vkObjArray[i] == null) ? null : vkObjArray[i].getPointer();
     }
     return buffers;
 }

/**
 *  Native interface for Vulkan method #26
 *  vkFlushMappedMemoryRanges 
 * 
 * @param device - 
 * @param memoryRangeCount - 
 * @param pMemoryRanges - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkFlushMappedMemoryRanges0(
             java.nio.ByteBuffer   device,
             int  memoryRangeCount,
             java.nio.ByteBuffer[]   pMemoryRangesArray);/* 
     //FIXED
                    
      VkDevice* ptr_device = (VkDevice*) device;      
     JBufferArray buffers (env, pMemoryRangesArray);          
     const VkMappedMemoryRange* pMemoryRanges = (const VkMappedMemoryRange*) buffers.getPointers();
     VkResult res = vkFlushMappedMemoryRanges(
                     (VkDevice) (*ptr_device),
                     (uint32_t) memoryRangeCount,
                     (const VkMappedMemoryRange*) pMemoryRanges);
                     
                     
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 27
 * <h2>Prototype</h2><pre>
 *  VkResult  vkInvalidateMappedMemoryRanges(
 *     VkDevice                                    device,
 *     uint32_t                                    memoryRangeCount,
 *     const VkMappedMemoryRange*                  pMemoryRanges);
 * </pre>
 * 
 * @param device - 
 * @param memoryRangeCount - 
 * @param pMemoryRanges - 
 * 
 * @return VkResult
 */
public VkResult vkInvalidateMappedMemoryRanges(
             VkDevice device,
             int memoryRangeCount,
             VkMappedMemoryRange[]  pMemoryRanges){
    
    
    ByteBuffer[] pMemoryRangesBuffers = getBuffers(pMemoryRanges, memoryRangeCount);
       
     int  _val = vkInvalidateMappedMemoryRanges0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     memoryRangeCount ,
                     pMemoryRangesBuffers);
      setBuffers(pMemoryRanges, pMemoryRangesBuffers);
      
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #27
 *  vkInvalidateMappedMemoryRanges 
 * 
 * @param device - 
 * @param memoryRangeCount - 
 * @param pMemoryRanges - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkInvalidateMappedMemoryRanges0(
             java.nio.ByteBuffer   device,
             int  memoryRangeCount,
             java.nio.ByteBuffer[]   pMemoryRanges);/*
                           
     VkDevice* ptr_device = (VkDevice*) device;     
     JBufferArray bufferArray (env, pMemoryRanges);
     PointerToAnything* buffers = bufferArray.getPointers();
     VkResult res = vkInvalidateMappedMemoryRanges(
                     (VkDevice) (*ptr_device),
                     (uint32_t) memoryRangeCount,
                     (const VkMappedMemoryRange*) buffers);
                     
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 28
 * <h2>Prototype</h2><pre>
 *  void  vkGetDeviceMemoryCommitment(
 *     VkDevice                                    device,
 *     VkDeviceMemory                              memory,
 *     VkDeviceSize*                               pCommittedMemoryInBytes);
 * </pre>
 * 
 * @param device - 
 * @param memory - 
 * @param pCommittedMemoryInBytes - 
 */
public void vkGetDeviceMemoryCommitment(
             VkDevice device,
             VkDeviceMemory memory,
             long[] pCommittedMemoryInBytes){
     vkGetDeviceMemoryCommitment0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (memory==null ? null : memory.getHandle()) /* ByteBuffer */ ,
             pCommittedMemoryInBytes  );

} 

/**
 *  Native interface for Vulkan method #28
 *  vkGetDeviceMemoryCommitment 
 * 
 * @param device - 
 * @param memory - 
 * @param pCommittedMemoryInBytes - 
 */
 private static native void vkGetDeviceMemoryCommitment0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   memory,
             long[]  pCommittedMemoryInBytes);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     vkGetDeviceMemoryCommitment(
                     (VkDevice) (*ptr_device),
                     (VkDeviceMemory) (*ptr_memory),
                     (VkDeviceSize*) pCommittedMemoryInBytes);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 29
 * <h2>Prototype</h2><pre>
 *  VkResult  vkBindBufferMemory(
 *     VkDevice                                    device,
 *     VkBuffer                                    buffer,
 *     VkDeviceMemory                              memory,
 *     VkDeviceSize                                memoryOffset);
 * </pre>
 * 
 * @param device - 
 * @param buffer - 
 * @param memory - 
 * @param memoryOffset - 
 * 
 * @return VkResult
 */
public VkResult vkBindBufferMemory(
             VkDevice device,
             VkBuffer buffer,
             VkDeviceMemory memory,
             long memoryOffset){
     int  _val = vkBindBufferMemory0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
                     (memory==null ? null : memory.getHandle()) /* ByteBuffer */ ,
                     memoryOffset  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #29
 *  vkBindBufferMemory 
 * 
 * @param device - 
 * @param buffer - 
 * @param memory - 
 * @param memoryOffset - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkBindBufferMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   buffer,
             java.nio.ByteBuffer   memory,
             long  memoryOffset);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     VkResult res = vkBindBufferMemory(
                     (VkDevice) (*ptr_device),
                     (VkBuffer) (*ptr_buffer),
                     (VkDeviceMemory) (*ptr_memory),
                     (VkDeviceSize) memoryOffset);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 30
 * <h2>Prototype</h2><pre>
 *  VkResult  vkBindImageMemory(
 *     VkDevice                                    device,
 *     VkImage                                     image,
 *     VkDeviceMemory                              memory,
 *     VkDeviceSize                                memoryOffset);
 * </pre>
 * 
 * @param device - 
 * @param image - 
 * @param memory - 
 * @param memoryOffset - 
 * 
 * @return VkResult
 */
public VkResult vkBindImageMemory(
             VkDevice device,
             VkImage image,
             VkDeviceMemory memory,
             long memoryOffset){
     int  _val = vkBindImageMemory0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
                     (memory==null ? null : memory.getHandle()) /* ByteBuffer */ ,
                     memoryOffset  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #30
 *  vkBindImageMemory 
 * 
 * @param device - 
 * @param image - 
 * @param memory - 
 * @param memoryOffset - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkBindImageMemory0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   image,
             java.nio.ByteBuffer   memory,
             long  memoryOffset);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImage* ptr_image = (VkImage*) image;
     VkDeviceMemory* ptr_memory = (VkDeviceMemory*) memory;
     VkResult res = vkBindImageMemory(
                     (VkDevice) (*ptr_device),
                     (VkImage) (*ptr_image),
                     (VkDeviceMemory) (*ptr_memory),
                     (VkDeviceSize) memoryOffset);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 31
 * <h2>Prototype</h2><pre>
 *  void  vkGetBufferMemoryRequirements(
 *     VkDevice                                    device,
 *     VkBuffer                                    buffer,
 *     VkMemoryRequirements*                       pMemoryRequirements);
 * </pre>
 * 
 * @param device - 
 * @param buffer - 
 * @param pMemoryRequirements - 
 */
public void vkGetBufferMemoryRequirements(
             VkDevice device,
             VkBuffer buffer,
             VkMemoryRequirements  pMemoryRequirements){
     vkGetBufferMemoryRequirements0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             (pMemoryRequirements==null ? null : pMemoryRequirements.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #31
 *  vkGetBufferMemoryRequirements 
 * 
 * @param device - 
 * @param buffer - 
 * @param pMemoryRequirements - 
 */
 private static native void vkGetBufferMemoryRequirements0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   buffer,
             java.nio.ByteBuffer   pMemoryRequirements);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkGetBufferMemoryRequirements(
                     (VkDevice) (*ptr_device),
                     (VkBuffer) (*ptr_buffer),
                     (VkMemoryRequirements*) pMemoryRequirements);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 32
 * <h2>Prototype</h2><pre>
 *  void  vkGetImageMemoryRequirements(
 *     VkDevice                                    device,
 *     VkImage                                     image,
 *     VkMemoryRequirements*                       pMemoryRequirements);
 * </pre>
 * 
 * @param device - 
 * @param image - 
 * @param pMemoryRequirements - 
 */
public void vkGetImageMemoryRequirements(
             VkDevice device,
             VkImage image,
             VkMemoryRequirements  pMemoryRequirements){
     vkGetImageMemoryRequirements0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             (pMemoryRequirements==null ? null : pMemoryRequirements.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #32
 *  vkGetImageMemoryRequirements 
 * 
 * @param device - 
 * @param image - 
 * @param pMemoryRequirements - 
 */
 private static native void vkGetImageMemoryRequirements0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   image,
             java.nio.ByteBuffer   pMemoryRequirements);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImage* ptr_image = (VkImage*) image;
     vkGetImageMemoryRequirements(
                     (VkDevice) (*ptr_device),
                     (VkImage) (*ptr_image),
                     (VkMemoryRequirements*) pMemoryRequirements);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 33
 * <h2>Prototype</h2><pre>
 *  void  vkGetImageSparseMemoryRequirements(
 *     VkDevice                                    device,
 *     VkImage                                     image,
 *     uint32_t*                                   pSparseMemoryRequirementCount,
 *     VkSparseImageMemoryRequirements*            pSparseMemoryRequirements);
 * </pre>
 * 
 * @param device - 
 * @param image - 
 * @param pSparseMemoryRequirementCount - 
 * @param pSparseMemoryRequirements - 
 */
public void vkGetImageSparseMemoryRequirements(
             VkDevice device,
             VkImage image,
             int[] pSparseMemoryRequirementCount,
             VkSparseImageMemoryRequirements[]  pSparseMemoryRequirements){
    
     ByteBuffer[] buffers = getBuffers(pSparseMemoryRequirements, pSparseMemoryRequirementCount[0]);
     
     vkGetImageSparseMemoryRequirements0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             pSparseMemoryRequirementCount ,
             buffers);
     
     setBuffers(pSparseMemoryRequirements, buffers);
} 

/**
 *  Native interface for Vulkan method #33
 *  vkGetImageSparseMemoryRequirements 
 * 
 * @param device - 
 * @param image - 
 * @param pSparseMemoryRequirementCount - 
 * @param pSparseMemoryRequirements - 
 */
 private static native void vkGetImageSparseMemoryRequirements0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   image,
             int[]  pSparseMemoryRequirementCount,
             java.nio.ByteBuffer[]   pSparseMemoryRequirements);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImage* ptr_image = (VkImage*) image;
     JBufferArray buffers(env,pSparseMemoryRequirements);
     vkGetImageSparseMemoryRequirements(
                     (VkDevice) (*ptr_device),
                     (VkImage) (*ptr_image),
                     (uint32_t*) pSparseMemoryRequirementCount,
                     (VkSparseImageMemoryRequirements*) buffers.getPointers());

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 34
 * <h2>Prototype</h2><pre>
 *  void  vkGetPhysicalDeviceSparseImageFormatProperties(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkFormat                                    format,
 *     VkImageType                                 type,
 *     VkSampleCountFlagBits                       samples,
 *     VkImageUsageFlags                           usage,
 *     VkImageTiling                               tiling,
 *     uint32_t*                                   pPropertyCount,
 *     VkSparseImageFormatProperties*              pProperties);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param format - 
 * @param type - 
 * @param samples - 
 * @param usage - 
 * @param tiling - 
 * @param pPropertyCount - 
 * @param pProperties - 
 */
public void vkGetPhysicalDeviceSparseImageFormatProperties(
             VkPhysicalDevice physicalDevice,
             VkFormat format,
             VkImageType type,
             VkSampleCountFlagBits samples,
             int usage,
             VkImageTiling tiling,
             int[] pPropertyCount,
             VkSparseImageFormatProperties[]  pProperties){
    
     ByteBuffer[] buffers = getBuffers(pProperties, pPropertyCount[0]);
     vkGetPhysicalDeviceSparseImageFormatProperties0(
             (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
             format.getValue() /* enum */,
             type.getValue() /* enum */,
             samples.getValue() /* enum */,
             usage ,
             tiling.getValue() /* enum */,
             pPropertyCount ,
             buffers );
     
     setBuffers(pProperties, buffers);

} 

/**
 *  Native interface for Vulkan method #34
 *  vkGetPhysicalDeviceSparseImageFormatProperties 
 * 
 * @param physicalDevice - 
 * @param format - 
 * @param type - 
 * @param samples - 
 * @param usage - 
 * @param tiling - 
 * @param pPropertyCount - 
 * @param pProperties - 
 */
 private static native void vkGetPhysicalDeviceSparseImageFormatProperties0(
             java.nio.ByteBuffer   physicalDevice,
             int   format,
             int   type,
             int   samples,
             int  usage,
             int   tiling,
             int[]  pPropertyCount,
             java.nio.ByteBuffer[]   pProperties);/* 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     JBufferArray buffers (env, pProperties);
     
     vkGetPhysicalDeviceSparseImageFormatProperties(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkFormat) format,
                     (VkImageType) type,
                     (VkSampleCountFlagBits) samples,
                     (VkImageUsageFlags) usage,
                     (VkImageTiling) tiling,
                     (uint32_t*) pPropertyCount,
                     (VkSparseImageFormatProperties*) buffers.getPointers());

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 35
 * <h2>Prototype</h2><pre>
 *  VkResult  vkQueueBindSparse(
 *     VkQueue                                     queue,
 *     uint32_t                                    bindInfoCount,
 *     const VkBindSparseInfo*                     pBindInfo,
 *     VkFence                                     fence);
 * </pre>
 * 
 * @param queue - 
 * @param bindInfoCount - 
 * @param pBindInfo - 
 * @param fence - 
 * 
 * @return VkResult
 */
public VkResult vkQueueBindSparse(
             VkQueue queue,
             int bindInfoCount,
              VkBindSparseInfo  pBindInfo,
             VkFence fence){
     int  _val = vkQueueBindSparse0(
                     (queue==null ? null : queue.getHandle()) /* ByteBuffer */ ,
                     bindInfoCount ,
                     (pBindInfo==null ? null : pBindInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (fence==null ? null : fence.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #35
 *  vkQueueBindSparse 
 * 
 * @param queue - 
 * @param bindInfoCount - 
 * @param pBindInfo - 
 * @param fence - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkQueueBindSparse0(
             java.nio.ByteBuffer   queue,
             int  bindInfoCount,
             java.nio.ByteBuffer   pBindInfo,
             java.nio.ByteBuffer   fence);/* 
     VkQueue* ptr_queue = (VkQueue*) queue;
     VkFence* ptr_fence = (VkFence*) fence;
     VkResult res = vkQueueBindSparse(
                     (VkQueue) (*ptr_queue),
                     (uint32_t) bindInfoCount,
                     (const VkBindSparseInfo*) pBindInfo,
                     (VkFence) (*ptr_fence));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 36
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateFence(
 *     VkDevice                                    device,
 *     const VkFenceCreateInfo*                    pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkFence*                                    pFence);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pFence - 
 * 
 * @return VkResult
 */
public VkResult vkCreateFence(
             VkDevice device,
              VkFenceCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkFence  pFence){
     int  _val = vkCreateFence0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pFence==null ? null : pFence.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #36
 *  vkCreateFence 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pFence - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateFence0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pFence);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateFence(
                     (VkDevice) (*ptr_device),
                     (const VkFenceCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkFence*) pFence);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 37
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyFence(
 *     VkDevice                                    device,
 *     VkFence                                     fence,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param fence - 
 * @param pAllocator - 
 */
public void vkDestroyFence(
             VkDevice device,
             VkFence fence,
             VkAllocationCallbacks  pAllocator){
     vkDestroyFence0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (fence==null ? null : fence.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #37
 *  vkDestroyFence 
 * 
 * @param device - 
 * @param fence - 
 * @param pAllocator - 
 */
 private static native void vkDestroyFence0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   fence,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkFence* ptr_fence = (VkFence*) fence;
     vkDestroyFence(
                     (VkDevice) (*ptr_device),
                     (VkFence) (*ptr_fence),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 38
 * <h2>Prototype</h2><pre>
 *  VkResult  vkResetFences(
 *     VkDevice                                    device,
 *     uint32_t                                    fenceCount,
 *     const VkFence*                              pFences);
 * </pre>
 * 
 * @param device - 
 * @param fenceCount - 
 * @param pFences - 
 * 
 * @return VkResult
 */
public VkResult vkResetFences(
             VkDevice device,
             int fenceCount,
             VkFence[]  pFences){
     ByteBuffer[] buffers = getBuffers(pFences, fenceCount);
     int  _val = vkResetFences0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     fenceCount ,
                     buffers);
     
     setBuffers(pFences, buffers);
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #38
 *  vkResetFences 
 * 
 * @param device - 
 * @param fenceCount - 
 * @param pFences - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkResetFences0(
             java.nio.ByteBuffer   device,
             int  fenceCount,
             java.nio.ByteBuffer[]   pFences);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     JBufferArray buffers (env, pFences);
     
     VkResult res = vkResetFences(
                     (VkDevice) (*ptr_device),
                     (uint32_t) fenceCount,
                     (const VkFence*) buffers.getPointers());
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 39
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetFenceStatus(
 *     VkDevice                                    device,
 *     VkFence                                     fence);
 * </pre>
 * 
 * @param device - 
 * @param fence - 
 * 
 * @return VkResult
 */
public VkResult vkGetFenceStatus(
             VkDevice device,
             VkFence fence){
     int  _val = vkGetFenceStatus0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (fence==null ? null : fence.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #39
 *  vkGetFenceStatus 
 * 
 * @param device - 
 * @param fence - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetFenceStatus0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   fence);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkFence* ptr_fence = (VkFence*) fence;
     VkResult res = vkGetFenceStatus(
                     (VkDevice) (*ptr_device),
                     (VkFence) (*ptr_fence));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 40
 * <h2>Prototype</h2><pre>
 *  VkResult  vkWaitForFences(
 *     VkDevice                                    device,
 *     uint32_t                                    fenceCount,
 *     const VkFence*                              pFences,
 *     VkBool32                                    waitAll,
 *     uint64_t                                    timeout);
 * </pre>
 * 
 * @param device - 
 * @param fenceCount - 
 * @param pFences - 
 * @param waitAll - 
 * @param timeout - 
 * 
 * @return VkResult
 */
public VkResult vkWaitForFences(
             VkDevice device,
             int fenceCount,
             VkFence[]  pFences,
             boolean waitAll,
             long timeout){
     ByteBuffer[] buffers = getBuffers(pFences, fenceCount); 
     int  _val = vkWaitForFences0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     fenceCount ,
                     buffers /* ByteBuffer */ ,
                     waitAll ,
                     timeout  );
      setBuffers(pFences, buffers);
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #40
 *  vkWaitForFences 
 * 
 * @param device - 
 * @param fenceCount - 
 * @param pFences - 
 * @param waitAll - 
 * @param timeout - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkWaitForFences0(
             java.nio.ByteBuffer   device,
             int  fenceCount,
             java.nio.ByteBuffer[]   pFences,
             boolean  waitAll,
             long  timeout);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     JBufferArray buffers (env, pFences);
     
     VkResult res = vkWaitForFences(
                     (VkDevice) (*ptr_device),
                     (uint32_t) fenceCount,
                     (const VkFence*) buffers.getPointers(),
                     (VkBool32) waitAll,
                     (uint64_t) timeout);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 41
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateSemaphore(
 *     VkDevice                                    device,
 *     const VkSemaphoreCreateInfo*                pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSemaphore*                                pSemaphore);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSemaphore - 
 * 
 * @return VkResult
 */
public VkResult vkCreateSemaphore(
             VkDevice device,
              VkSemaphoreCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSemaphore  pSemaphore){
     int  _val = vkCreateSemaphore0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSemaphore==null ? null : pSemaphore.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #41
 *  vkCreateSemaphore 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSemaphore - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateSemaphore0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSemaphore);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateSemaphore(
                     (VkDevice) (*ptr_device),
                     (const VkSemaphoreCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSemaphore*) pSemaphore);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 42
 * <h2>Prototype</h2><pre>
 *  void  vkDestroySemaphore(
 *     VkDevice                                    device,
 *     VkSemaphore                                 semaphore,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param semaphore - 
 * @param pAllocator - 
 */
public void vkDestroySemaphore(
             VkDevice device,
             VkSemaphore semaphore,
             VkAllocationCallbacks  pAllocator){
     vkDestroySemaphore0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (semaphore==null ? null : semaphore.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #42
 *  vkDestroySemaphore 
 * 
 * @param device - 
 * @param semaphore - 
 * @param pAllocator - 
 */
 private static native void vkDestroySemaphore0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   semaphore,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkSemaphore* ptr_semaphore = (VkSemaphore*) semaphore;
     vkDestroySemaphore(
                     (VkDevice) (*ptr_device),
                     (VkSemaphore) (*ptr_semaphore),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 43
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateEvent(
 *     VkDevice                                    device,
 *     const VkEventCreateInfo*                    pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkEvent*                                    pEvent);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pEvent - 
 * 
 * @return VkResult
 */
public VkResult vkCreateEvent(
             VkDevice device,
             VkEventCreateInfo  pCreateInfo,
             VkAllocationCallbacks  pAllocator,
             VkEvent  pEvent){
     int  _val = vkCreateEvent0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pEvent==null ? null : pEvent.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #43
 *  vkCreateEvent 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pEvent - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateEvent0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pEvent);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateEvent(
                     (VkDevice) (*ptr_device),
                     (const VkEventCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkEvent*) pEvent);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 44
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyEvent(
 *     VkDevice                                    device,
 *     VkEvent                                     event,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param event - 
 * @param pAllocator - 
 */
public void vkDestroyEvent(
             VkDevice device,
             VkEvent event,
              VkAllocationCallbacks  pAllocator){
     vkDestroyEvent0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (event==null ? null : event.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #44
 *  vkDestroyEvent 
 * 
 * @param device - 
 * @param event - 
 * @param pAllocator - 
 */
 private static native void vkDestroyEvent0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   event,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkEvent* ptr_event = (VkEvent*) event;
     vkDestroyEvent(
                     (VkDevice) (*ptr_device),
                     (VkEvent) (*ptr_event),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 45
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetEventStatus(
 *     VkDevice                                    device,
 *     VkEvent                                     event);
 * </pre>
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult
 */
public VkResult vkGetEventStatus(
             VkDevice device,
             VkEvent event){
     int  _val = vkGetEventStatus0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (event==null ? null : event.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #45
 *  vkGetEventStatus 
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetEventStatus0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   event);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkEvent* ptr_event = (VkEvent*) event;
     VkResult res = vkGetEventStatus(
                     (VkDevice) (*ptr_device),
                     (VkEvent) (*ptr_event));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 46
 * <h2>Prototype</h2><pre>
 *  VkResult  vkSetEvent(
 *     VkDevice                                    device,
 *     VkEvent                                     event);
 * </pre>
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult
 */
public VkResult vkSetEvent(
             VkDevice device,
             VkEvent event){
     int  _val = vkSetEvent0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (event==null ? null : event.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #46
 *  vkSetEvent 
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkSetEvent0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   event);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkEvent* ptr_event = (VkEvent*) event;
     VkResult res = vkSetEvent(
                     (VkDevice) (*ptr_device),
                     (VkEvent) (*ptr_event));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 47
 * <h2>Prototype</h2><pre>
 *  VkResult  vkResetEvent(
 *     VkDevice                                    device,
 *     VkEvent                                     event);
 * </pre>
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult
 */
public VkResult vkResetEvent(
             VkDevice device,
             VkEvent event){
     int  _val = vkResetEvent0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (event==null ? null : event.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #47
 *  vkResetEvent 
 * 
 * @param device - 
 * @param event - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkResetEvent0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   event);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkEvent* ptr_event = (VkEvent*) event;
     VkResult res = vkResetEvent(
                     (VkDevice) (*ptr_device),
                     (VkEvent) (*ptr_event));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 48
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateQueryPool(
 *     VkDevice                                    device,
 *     const VkQueryPoolCreateInfo*                pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkQueryPool*                                pQueryPool);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pQueryPool - 
 * 
 * @return VkResult
 */
public VkResult vkCreateQueryPool(
             VkDevice device,
              VkQueryPoolCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkQueryPool  pQueryPool){
     int  _val = vkCreateQueryPool0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pQueryPool==null ? null : pQueryPool.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #48
 *  vkCreateQueryPool 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pQueryPool - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateQueryPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pQueryPool);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateQueryPool(
                     (VkDevice) (*ptr_device),
                     (const VkQueryPoolCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkQueryPool*) pQueryPool);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 49
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyQueryPool(
 *     VkDevice                                    device,
 *     VkQueryPool                                 queryPool,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param queryPool - 
 * @param pAllocator - 
 */
public void vkDestroyQueryPool(
             VkDevice device,
             VkQueryPool queryPool,
              VkAllocationCallbacks  pAllocator){
     vkDestroyQueryPool0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #49
 *  vkDestroyQueryPool 
 * 
 * @param device - 
 * @param queryPool - 
 * @param pAllocator - 
 */
 private static native void vkDestroyQueryPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   queryPool,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     vkDestroyQueryPool(
                     (VkDevice) (*ptr_device),
                     (VkQueryPool) (*ptr_queryPool),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 50
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetQueryPoolResults(
 *     VkDevice                                    device,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    firstQuery,
 *     uint32_t                                    queryCount,
 *     size_t                                      dataSize,
 *     void*                                       pData,
 *     VkDeviceSize                                stride,
 *     VkQueryResultFlags                          flags);
 * </pre>
 * 
 * @param device - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 * @param dataSize - 
 * @param pData - 
 * @param stride - 
 * @param flags - 
 * 
 * @return VkResult
 */
public VkResult vkGetQueryPoolResults(
             VkDevice device,
             VkQueryPool queryPool,
             int firstQuery,
             int queryCount,
             long dataSize,
             java.nio.Buffer pData,
             long stride,
             int flags){
     
     // pData must respect Buffers position
     Buffer pData2 = (pData.position() == 0)? pData : slice(pData);
     int  _val = vkGetQueryPoolResults0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
                     firstQuery ,
                     queryCount ,
                     dataSize ,
                     pData2,
                     stride ,
                     flags  );
      return VkResult.fromValue(_val);
} 

/**
 * Slice a buffer at current position
 * @param b - buffer to slice
 * @return sliced buffer
 */
 private static final Buffer slice(Buffer b){
     if(b==null) return null;
     if(b.position()==0) return b;
     
     if(b instanceof java.nio.IntBuffer) return ((java.nio.IntBuffer)b).slice();
     if(b instanceof java.nio.LongBuffer) return ((java.nio.LongBuffer)b).slice();
     if(b instanceof java.nio.ByteBuffer) return ((java.nio.LongBuffer)b).slice();
     if(b instanceof java.nio.FloatBuffer) return ((java.nio.FloatBuffer)b).slice();
     if(b instanceof java.nio.CharBuffer) return ((java.nio.CharBuffer)b).slice();
     if(b instanceof java.nio.DoubleBuffer) return ((java.nio.DoubleBuffer)b).slice();
          
     return b;
 }

/**
 *  Native interface for Vulkan method #50
 *  vkGetQueryPoolResults 
 * 
 * @param device - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 * @param dataSize - 
 * @param pData - 
 * @param stride - 
 * @param flags - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetQueryPoolResults0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   queryPool,
             int  firstQuery,
             int  queryCount,
             long  dataSize,
             java.nio.Buffer  pData,
             long  stride,
             int  flags);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     VkResult res = vkGetQueryPoolResults(
                     (VkDevice) (*ptr_device),
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) firstQuery,
                     (uint32_t) queryCount,
                     (size_t) dataSize,
                     (void*) pData,
                     (VkDeviceSize) stride,
                     (VkQueryResultFlags) flags);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 51
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateBuffer(
 *     VkDevice                                    device,
 *     const VkBufferCreateInfo*                   pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkBuffer*                                   pBuffer);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pBuffer - 
 * 
 * @return VkResult
 */
public VkResult vkCreateBuffer(
              VkDevice device,
              VkBufferCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkBuffer[]  pBuffer){
    
     int[] result = {0};     
     ByteBuffer handle = vkCreateBuffer0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     result);   
     
     if(pBuffer[0]==null){
         pBuffer[0] = new VkHandle(handle);
     }else{
         pBuffer[0].setPointer(handle);
     }
      return VkResult.fromValue(result[0]);
} 

/**
 *  Native interface for Vulkan method #51
 *  vkCreateBuffer 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pBuffer - 
 * 
 * @return VkResult as int  
 */
 private static native ByteBuffer vkCreateBuffer0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,             
             int[] result);/* 
             
     VkDevice* ptr_device = (VkDevice*) device;
     VkBuffer* pBuffer = NULL;
         
     VkResult res = vkCreateBuffer(
                     (VkDevice) (*ptr_device),
                     (const VkBufferCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkBuffer*) pBuffer);
      result[0] = res;
      if(pBuffer){      
            jobject buffer = (jobject)(env->NewDirectByteBuffer((void*)(pBuffer), sizeof(void*)));  
           return buffer;               
      }
      
      return NULL;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 52
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyBuffer(
 *     VkDevice                                    device,
 *     VkBuffer                                    buffer,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param buffer - 
 * @param pAllocator - 
 */
public void vkDestroyBuffer(
             VkDevice device,
             VkBuffer buffer,
             VkAllocationCallbacks  pAllocator){
     vkDestroyBuffer0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #52
 *  vkDestroyBuffer 
 * 
 * @param device - 
 * @param buffer - 
 * @param pAllocator - 
 */
 private static native void vkDestroyBuffer0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   buffer,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkDestroyBuffer(
                     (VkDevice) (*ptr_device),
                     (VkBuffer) (*ptr_buffer),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 53
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateBufferView(
 *     VkDevice                                    device,
 *     const VkBufferViewCreateInfo*               pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkBufferView*                               pView);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pView - 
 * 
 * @return VkResult
 */
public VkResult vkCreateBufferView(
              VkDevice device,
              VkBufferViewCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkBufferView[]  pView){
    
     ByteBuffer[] buffer = new ByteBuffer[1];
     int  _val = vkCreateBufferView0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     buffer);
     
     ByteBuffer handle = buffer[0]; 
     // smart checking
     if(pView[0] == null){
         pView[0] = new VkHandle(handle);
     }else{
         pView[0].setPointer(handle);    
     }
     
     return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #53
 *  vkCreateBufferView 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pView - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateBufferView0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer[]   _pView);/* 
             
     VkDevice* ptr_device = (VkDevice*) device;
     VkBufferView* pView = NULL;
     
     VkResult res = vkCreateBufferView(
                     (VkDevice) (*ptr_device),
                     (const VkBufferViewCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkBufferView*) pView);
      if(pView){
         jobject buffer = (jobject)(env->NewDirectByteBuffer((void *)pView, sizeof(void*)));        
         env->SetObjectArrayElement(_pView, 0, buffer);
       }
                     
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 54
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyBufferView(
 *     VkDevice                                    device,
 *     VkBufferView                                bufferView,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param bufferView - 
 * @param pAllocator - 
 */
public void vkDestroyBufferView(
             VkDevice device,
             VkBufferView bufferView,
              VkAllocationCallbacks  pAllocator){
     vkDestroyBufferView0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (bufferView==null ? null : bufferView.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #54
 *  vkDestroyBufferView 
 * 
 * @param device - 
 * @param bufferView - 
 * @param pAllocator - 
 */
 private static native void vkDestroyBufferView0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   bufferView,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkBufferView* ptr_bufferView = (VkBufferView*) bufferView;
     vkDestroyBufferView(
                     (VkDevice) (*ptr_device),
                     (VkBufferView) (*ptr_bufferView),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 55
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateImage(
 *     VkDevice                                    device,
 *     const VkImageCreateInfo*                    pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkImage*                                    pImage);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pImage - 
 * 
 * @return VkResult
 */
public VkResult vkCreateImage(
             VkDevice device,
              VkImageCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkImage  pImage){
     int  _val = vkCreateImage0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pImage==null ? null : pImage.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #55
 *  vkCreateImage 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pImage - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateImage0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pImage);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateImage(
                     (VkDevice) (*ptr_device),
                     (const VkImageCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkImage*) pImage);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 56
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyImage(
 *     VkDevice                                    device,
 *     VkImage                                     image,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param image - 
 * @param pAllocator - 
 */
public void vkDestroyImage(
             VkDevice device,
             VkImage image,
              VkAllocationCallbacks  pAllocator){
     vkDestroyImage0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #56
 *  vkDestroyImage 
 * 
 * @param device - 
 * @param image - 
 * @param pAllocator - 
 */
 private static native void vkDestroyImage0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   image,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImage* ptr_image = (VkImage*) image;
     vkDestroyImage(
                     (VkDevice) (*ptr_device),
                     (VkImage) (*ptr_image),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 57
 * <h2>Prototype</h2><pre>
 *  void  vkGetImageSubresourceLayout(
 *     VkDevice                                    device,
 *     VkImage                                     image,
 *     const VkImageSubresource*                   pSubresource,
 *     VkSubresourceLayout*                        pLayout);
 * </pre>
 * 
 * @param device - 
 * @param image - 
 * @param pSubresource - 
 * @param pLayout - 
 */
public void vkGetImageSubresourceLayout(
             VkDevice device,
             VkImage image,
              VkImageSubresource  pSubresource,
              VkSubresourceLayout  pLayout){
     vkGetImageSubresourceLayout0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             (pSubresource==null ? null : pSubresource.getPointerStruct()) /* ByteBuffer */ ,
             (pLayout==null ? null : pLayout.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #57
 *  vkGetImageSubresourceLayout 
 * 
 * @param device - 
 * @param image - 
 * @param pSubresource - 
 * @param pLayout - 
 */
 private static native void vkGetImageSubresourceLayout0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   image,
             java.nio.ByteBuffer   pSubresource,
             java.nio.ByteBuffer   pLayout);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImage* ptr_image = (VkImage*) image;
     vkGetImageSubresourceLayout(
                     (VkDevice) (*ptr_device),
                     (VkImage) (*ptr_image),
                     (const VkImageSubresource*) pSubresource,
                     (VkSubresourceLayout*) pLayout);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 58
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateImageView(
 *     VkDevice                                    device,
 *     const VkImageViewCreateInfo*                pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkImageView*                                pView);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pView - 
 * 
 * @return VkResult
 */
public VkResult vkCreateImageView(
             VkDevice device,
              VkImageViewCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkImageView  pView){
     int  _val = vkCreateImageView0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pView==null ? null : pView.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #58
 *  vkCreateImageView 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pView - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateImageView0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pView);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateImageView(
                     (VkDevice) (*ptr_device),
                     (const VkImageViewCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkImageView*) pView);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 59
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyImageView(
 *     VkDevice                                    device,
 *     VkImageView                                 imageView,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param imageView - 
 * @param pAllocator - 
 */
public void vkDestroyImageView(
             VkDevice device,
             VkImageView imageView,
              VkAllocationCallbacks  pAllocator){
     vkDestroyImageView0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (imageView==null ? null : imageView.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #59
 *  vkDestroyImageView 
 * 
 * @param device - 
 * @param imageView - 
 * @param pAllocator - 
 */
 private static native void vkDestroyImageView0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   imageView,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkImageView* ptr_imageView = (VkImageView*) imageView;
     vkDestroyImageView(
                     (VkDevice) (*ptr_device),
                     (VkImageView) (*ptr_imageView),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 60
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateShaderModule(
 *     VkDevice                                    device,
 *     const VkShaderModuleCreateInfo*             pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkShaderModule*                             pShaderModule);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pShaderModule - 
 * 
 * @return VkResult
 */
public VkResult vkCreateShaderModule(
             VkDevice device,
              VkShaderModuleCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkShaderModule  pShaderModule){
     int  _val = vkCreateShaderModule0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pShaderModule==null ? null : pShaderModule.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #60
 *  vkCreateShaderModule 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pShaderModule - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateShaderModule0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pShaderModule);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateShaderModule(
                     (VkDevice) (*ptr_device),
                     (const VkShaderModuleCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkShaderModule*) pShaderModule);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 61
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyShaderModule(
 *     VkDevice                                    device,
 *     VkShaderModule                              shaderModule,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param shaderModule - 
 * @param pAllocator - 
 */
public void vkDestroyShaderModule(
             VkDevice device,
             VkShaderModule shaderModule,
              VkAllocationCallbacks  pAllocator){
     vkDestroyShaderModule0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (shaderModule==null ? null : shaderModule.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #61
 *  vkDestroyShaderModule 
 * 
 * @param device - 
 * @param shaderModule - 
 * @param pAllocator - 
 */
 private static native void vkDestroyShaderModule0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   shaderModule,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkShaderModule* ptr_shaderModule = (VkShaderModule*) shaderModule;
     vkDestroyShaderModule(
                     (VkDevice) (*ptr_device),
                     (VkShaderModule) (*ptr_shaderModule),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 62
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreatePipelineCache(
 *     VkDevice                                    device,
 *     const VkPipelineCacheCreateInfo*            pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkPipelineCache*                            pPipelineCache);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pPipelineCache - 
 * 
 * @return VkResult
 */
public VkResult vkCreatePipelineCache(
             VkDevice device,
              VkPipelineCacheCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkPipelineCache  pPipelineCache){
     int  _val = vkCreatePipelineCache0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pPipelineCache==null ? null : pPipelineCache.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #62
 *  vkCreatePipelineCache 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pPipelineCache - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreatePipelineCache0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pPipelineCache);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreatePipelineCache(
                     (VkDevice) (*ptr_device),
                     (const VkPipelineCacheCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkPipelineCache*) pPipelineCache);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 63
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyPipelineCache(
 *     VkDevice                                    device,
 *     VkPipelineCache                             pipelineCache,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param pAllocator - 
 */
public void vkDestroyPipelineCache(
             VkDevice device,
             VkPipelineCache pipelineCache,
              VkAllocationCallbacks  pAllocator){
     vkDestroyPipelineCache0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (pipelineCache==null ? null : pipelineCache.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #63
 *  vkDestroyPipelineCache 
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param pAllocator - 
 */
 private static native void vkDestroyPipelineCache0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipelineCache,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineCache* ptr_pipelineCache = (VkPipelineCache*) pipelineCache;
     vkDestroyPipelineCache(
                     (VkDevice) (*ptr_device),
                     (VkPipelineCache) (*ptr_pipelineCache),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 64
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPipelineCacheData(
 *     VkDevice                                    device,
 *     VkPipelineCache                             pipelineCache,
 *     size_t*                                     pDataSize,
 *     void*                                       pData);
 * </pre>
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param pDataSize - 
 * @param pData - 
 * 
 * @return VkResult
 */
public VkResult vkGetPipelineCacheData(
             VkDevice device,
             VkPipelineCache pipelineCache,
             long[] pDataSize,
             java.nio.Buffer pData){
     int  _val = vkGetPipelineCacheData0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pipelineCache==null ? null : pipelineCache.getHandle()) /* ByteBuffer */ ,
                     pDataSize ,
                     pData  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #64
 *  vkGetPipelineCacheData 
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param pDataSize - 
 * @param pData - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPipelineCacheData0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipelineCache,
             long[]  pDataSize,
             java.nio.Buffer  pData);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineCache* ptr_pipelineCache = (VkPipelineCache*) pipelineCache;
     VkResult res = vkGetPipelineCacheData(
                     (VkDevice) (*ptr_device),
                     (VkPipelineCache) (*ptr_pipelineCache),
                     (size_t*) pDataSize,
                     (void*) pData);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 65
 * <h2>Prototype</h2><pre>
 *  VkResult  vkMergePipelineCaches(
 *     VkDevice                                    device,
 *     VkPipelineCache                             dstCache,
 *     uint32_t                                    srcCacheCount,
 *     const VkPipelineCache*                      pSrcCaches);
 * </pre>
 * 
 * @param device - 
 * @param dstCache - 
 * @param srcCacheCount - 
 * @param pSrcCaches - 
 * 
 * @return VkResult
 */
public VkResult vkMergePipelineCaches(
             VkDevice device,
             VkPipelineCache dstCache,
             int srcCacheCount,
              VkPipelineCache  pSrcCaches){
     int  _val = vkMergePipelineCaches0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (dstCache==null ? null : dstCache.getHandle()) /* ByteBuffer */ ,
                     srcCacheCount ,
                     (pSrcCaches==null ? null : pSrcCaches.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #65
 *  vkMergePipelineCaches 
 * 
 * @param device - 
 * @param dstCache - 
 * @param srcCacheCount - 
 * @param pSrcCaches - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkMergePipelineCaches0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   dstCache,
             int  srcCacheCount,
             java.nio.ByteBuffer   pSrcCaches);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineCache* ptr_dstCache = (VkPipelineCache*) dstCache;
     VkResult res = vkMergePipelineCaches(
                     (VkDevice) (*ptr_device),
                     (VkPipelineCache) (*ptr_dstCache),
                     (uint32_t) srcCacheCount,
                     (const VkPipelineCache*) pSrcCaches);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 66
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateGraphicsPipelines(
 *     VkDevice                                    device,
 *     VkPipelineCache                             pipelineCache,
 *     uint32_t                                    createInfoCount,
 *     const VkGraphicsPipelineCreateInfo*         pCreateInfos,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkPipeline*                                 pPipelines);
 * </pre>
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param createInfoCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pPipelines - 
 * 
 * @return VkResult
 */
public VkResult vkCreateGraphicsPipelines(
             VkDevice device,
             VkPipelineCache pipelineCache,
             int createInfoCount,
              VkGraphicsPipelineCreateInfo  pCreateInfos,
              VkAllocationCallbacks  pAllocator,
              VkPipeline  pPipelines){
     int  _val = vkCreateGraphicsPipelines0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pipelineCache==null ? null : pipelineCache.getHandle()) /* ByteBuffer */ ,
                     createInfoCount ,
                     (pCreateInfos==null ? null : pCreateInfos.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pPipelines==null ? null : pPipelines.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #66
 *  vkCreateGraphicsPipelines 
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param createInfoCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pPipelines - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateGraphicsPipelines0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipelineCache,
             int  createInfoCount,
             java.nio.ByteBuffer   pCreateInfos,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pPipelines);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineCache* ptr_pipelineCache = (VkPipelineCache*) pipelineCache;
     VkResult res = vkCreateGraphicsPipelines(
                     (VkDevice) (*ptr_device),
                     (VkPipelineCache) (*ptr_pipelineCache),
                     (uint32_t) createInfoCount,
                     (const VkGraphicsPipelineCreateInfo*) pCreateInfos,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkPipeline*) pPipelines);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 67
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateComputePipelines(
 *     VkDevice                                    device,
 *     VkPipelineCache                             pipelineCache,
 *     uint32_t                                    createInfoCount,
 *     const VkComputePipelineCreateInfo*          pCreateInfos,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkPipeline*                                 pPipelines);
 * </pre>
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param createInfoCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pPipelines - 
 * 
 * @return VkResult
 */
public VkResult vkCreateComputePipelines(
             VkDevice device,
             VkPipelineCache pipelineCache,
             int createInfoCount,
              VkComputePipelineCreateInfo  pCreateInfos,
              VkAllocationCallbacks  pAllocator,
              VkPipeline  pPipelines){
     int  _val = vkCreateComputePipelines0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pipelineCache==null ? null : pipelineCache.getHandle()) /* ByteBuffer */ ,
                     createInfoCount ,
                     (pCreateInfos==null ? null : pCreateInfos.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pPipelines==null ? null : pPipelines.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #67
 *  vkCreateComputePipelines 
 * 
 * @param device - 
 * @param pipelineCache - 
 * @param createInfoCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pPipelines - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateComputePipelines0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipelineCache,
             int  createInfoCount,
             java.nio.ByteBuffer   pCreateInfos,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pPipelines);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineCache* ptr_pipelineCache = (VkPipelineCache*) pipelineCache;
     VkResult res = vkCreateComputePipelines(
                     (VkDevice) (*ptr_device),
                     (VkPipelineCache) (*ptr_pipelineCache),
                     (uint32_t) createInfoCount,
                     (const VkComputePipelineCreateInfo*) pCreateInfos,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkPipeline*) pPipelines);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 68
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyPipeline(
 *     VkDevice                                    device,
 *     VkPipeline                                  pipeline,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param pipeline - 
 * @param pAllocator - 
 */
public void vkDestroyPipeline(
             VkDevice device,
             VkPipeline pipeline,
              VkAllocationCallbacks  pAllocator){
     vkDestroyPipeline0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (pipeline==null ? null : pipeline.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #68
 *  vkDestroyPipeline 
 * 
 * @param device - 
 * @param pipeline - 
 * @param pAllocator - 
 */
 private static native void vkDestroyPipeline0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipeline,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipeline* ptr_pipeline = (VkPipeline*) pipeline;
     vkDestroyPipeline(
                     (VkDevice) (*ptr_device),
                     (VkPipeline) (*ptr_pipeline),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 69
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreatePipelineLayout(
 *     VkDevice                                    device,
 *     const VkPipelineLayoutCreateInfo*           pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkPipelineLayout*                           pPipelineLayout);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pPipelineLayout - 
 * 
 * @return VkResult
 */
public VkResult vkCreatePipelineLayout(
             VkDevice device,
              VkPipelineLayoutCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkPipelineLayout  pPipelineLayout){
     int  _val = vkCreatePipelineLayout0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pPipelineLayout==null ? null : pPipelineLayout.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #69
 *  vkCreatePipelineLayout 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pPipelineLayout - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreatePipelineLayout0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pPipelineLayout);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreatePipelineLayout(
                     (VkDevice) (*ptr_device),
                     (const VkPipelineLayoutCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkPipelineLayout*) pPipelineLayout);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 70
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyPipelineLayout(
 *     VkDevice                                    device,
 *     VkPipelineLayout                            pipelineLayout,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param pipelineLayout - 
 * @param pAllocator - 
 */
public void vkDestroyPipelineLayout(
             VkDevice device,
             VkPipelineLayout pipelineLayout,
              VkAllocationCallbacks  pAllocator){
     vkDestroyPipelineLayout0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (pipelineLayout==null ? null : pipelineLayout.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #70
 *  vkDestroyPipelineLayout 
 * 
 * @param device - 
 * @param pipelineLayout - 
 * @param pAllocator - 
 */
 private static native void vkDestroyPipelineLayout0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pipelineLayout,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkPipelineLayout* ptr_pipelineLayout = (VkPipelineLayout*) pipelineLayout;
     vkDestroyPipelineLayout(
                     (VkDevice) (*ptr_device),
                     (VkPipelineLayout) (*ptr_pipelineLayout),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 71
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateSampler(
 *     VkDevice                                    device,
 *     const VkSamplerCreateInfo*                  pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSampler*                                  pSampler);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSampler - 
 * 
 * @return VkResult
 */
public VkResult vkCreateSampler(
             VkDevice device,
              VkSamplerCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSampler  pSampler){
     int  _val = vkCreateSampler0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSampler==null ? null : pSampler.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #71
 *  vkCreateSampler 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSampler - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateSampler0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSampler);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateSampler(
                     (VkDevice) (*ptr_device),
                     (const VkSamplerCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSampler*) pSampler);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 72
 * <h2>Prototype</h2><pre>
 *  void  vkDestroySampler(
 *     VkDevice                                    device,
 *     VkSampler                                   sampler,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param sampler - 
 * @param pAllocator - 
 */
public void vkDestroySampler(
             VkDevice device,
             VkSampler sampler,
              VkAllocationCallbacks  pAllocator){
     vkDestroySampler0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (sampler==null ? null : sampler.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #72
 *  vkDestroySampler 
 * 
 * @param device - 
 * @param sampler - 
 * @param pAllocator - 
 */
 private static native void vkDestroySampler0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   sampler,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkSampler* ptr_sampler = (VkSampler*) sampler;
     vkDestroySampler(
                     (VkDevice) (*ptr_device),
                     (VkSampler) (*ptr_sampler),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 73
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateDescriptorSetLayout(
 *     VkDevice                                    device,
 *     const VkDescriptorSetLayoutCreateInfo*      pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkDescriptorSetLayout*                      pSetLayout);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSetLayout - 
 * 
 * @return VkResult
 */
public VkResult vkCreateDescriptorSetLayout(
             VkDevice device,
              VkDescriptorSetLayoutCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkDescriptorSetLayout  pSetLayout){
     int  _val = vkCreateDescriptorSetLayout0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSetLayout==null ? null : pSetLayout.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #73
 *  vkCreateDescriptorSetLayout 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSetLayout - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateDescriptorSetLayout0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSetLayout);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateDescriptorSetLayout(
                     (VkDevice) (*ptr_device),
                     (const VkDescriptorSetLayoutCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkDescriptorSetLayout*) pSetLayout);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 74
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyDescriptorSetLayout(
 *     VkDevice                                    device,
 *     VkDescriptorSetLayout                       descriptorSetLayout,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param descriptorSetLayout - 
 * @param pAllocator - 
 */
public void vkDestroyDescriptorSetLayout(
             VkDevice device,
             VkDescriptorSetLayout descriptorSetLayout,
              VkAllocationCallbacks  pAllocator){
     vkDestroyDescriptorSetLayout0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (descriptorSetLayout==null ? null : descriptorSetLayout.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #74
 *  vkDestroyDescriptorSetLayout 
 * 
 * @param device - 
 * @param descriptorSetLayout - 
 * @param pAllocator - 
 */
 private static native void vkDestroyDescriptorSetLayout0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   descriptorSetLayout,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDescriptorSetLayout* ptr_descriptorSetLayout = (VkDescriptorSetLayout*) descriptorSetLayout;
     vkDestroyDescriptorSetLayout(
                     (VkDevice) (*ptr_device),
                     (VkDescriptorSetLayout) (*ptr_descriptorSetLayout),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 75
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateDescriptorPool(
 *     VkDevice                                    device,
 *     const VkDescriptorPoolCreateInfo*           pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkDescriptorPool*                           pDescriptorPool);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pDescriptorPool - 
 * 
 * @return VkResult
 */
public VkResult vkCreateDescriptorPool(
             VkDevice device,
              VkDescriptorPoolCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkDescriptorPool  pDescriptorPool){
     int  _val = vkCreateDescriptorPool0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pDescriptorPool==null ? null : pDescriptorPool.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #75
 *  vkCreateDescriptorPool 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pDescriptorPool - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateDescriptorPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pDescriptorPool);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateDescriptorPool(
                     (VkDevice) (*ptr_device),
                     (const VkDescriptorPoolCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkDescriptorPool*) pDescriptorPool);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 76
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyDescriptorPool(
 *     VkDevice                                    device,
 *     VkDescriptorPool                            descriptorPool,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param pAllocator - 
 */
public void vkDestroyDescriptorPool(
             VkDevice device,
             VkDescriptorPool descriptorPool,
              VkAllocationCallbacks  pAllocator){
     vkDestroyDescriptorPool0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (descriptorPool==null ? null : descriptorPool.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #76
 *  vkDestroyDescriptorPool 
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param pAllocator - 
 */
 private static native void vkDestroyDescriptorPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   descriptorPool,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDescriptorPool* ptr_descriptorPool = (VkDescriptorPool*) descriptorPool;
     vkDestroyDescriptorPool(
                     (VkDevice) (*ptr_device),
                     (VkDescriptorPool) (*ptr_descriptorPool),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 77
 * <h2>Prototype</h2><pre>
 *  VkResult  vkResetDescriptorPool(
 *     VkDevice                                    device,
 *     VkDescriptorPool                            descriptorPool,
 *     VkDescriptorPoolResetFlags                  flags);
 * </pre>
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param flags - 
 * 
 * @return VkResult
 */
public VkResult vkResetDescriptorPool(
             VkDevice device,
             VkDescriptorPool descriptorPool,
             int flags){
     int  _val = vkResetDescriptorPool0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (descriptorPool==null ? null : descriptorPool.getHandle()) /* ByteBuffer */ ,
                     flags  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #77
 *  vkResetDescriptorPool 
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param flags - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkResetDescriptorPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   descriptorPool,
             int  flags);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDescriptorPool* ptr_descriptorPool = (VkDescriptorPool*) descriptorPool;
     VkResult res = vkResetDescriptorPool(
                     (VkDevice) (*ptr_device),
                     (VkDescriptorPool) (*ptr_descriptorPool),
                     (VkDescriptorPoolResetFlags) flags);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 78
 * <h2>Prototype</h2><pre>
 *  VkResult  vkAllocateDescriptorSets(
 *     VkDevice                                    device,
 *     const VkDescriptorSetAllocateInfo*          pAllocateInfo,
 *     VkDescriptorSet*                            pDescriptorSets);
 * </pre>
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pDescriptorSets - 
 * 
 * @return VkResult
 */
public VkResult vkAllocateDescriptorSets(
             VkDevice device,
              VkDescriptorSetAllocateInfo  pAllocateInfo,
              VkDescriptorSet  pDescriptorSets){
     int  _val = vkAllocateDescriptorSets0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pAllocateInfo==null ? null : pAllocateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pDescriptorSets==null ? null : pDescriptorSets.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #78
 *  vkAllocateDescriptorSets 
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pDescriptorSets - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkAllocateDescriptorSets0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pAllocateInfo,
             java.nio.ByteBuffer   pDescriptorSets);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkAllocateDescriptorSets(
                     (VkDevice) (*ptr_device),
                     (const VkDescriptorSetAllocateInfo*) pAllocateInfo,
                     (VkDescriptorSet*) pDescriptorSets);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 79
 * <h2>Prototype</h2><pre>
 *  VkResult  vkFreeDescriptorSets(
 *     VkDevice                                    device,
 *     VkDescriptorPool                            descriptorPool,
 *     uint32_t                                    descriptorSetCount,
 *     const VkDescriptorSet*                      pDescriptorSets);
 * </pre>
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param descriptorSetCount - 
 * @param pDescriptorSets - 
 * 
 * @return VkResult
 */
public VkResult vkFreeDescriptorSets(
             VkDevice device,
             VkDescriptorPool descriptorPool,
             int descriptorSetCount,
              VkDescriptorSet  pDescriptorSets){
     int  _val = vkFreeDescriptorSets0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (descriptorPool==null ? null : descriptorPool.getHandle()) /* ByteBuffer */ ,
                     descriptorSetCount ,
                     (pDescriptorSets==null ? null : pDescriptorSets.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #79
 *  vkFreeDescriptorSets 
 * 
 * @param device - 
 * @param descriptorPool - 
 * @param descriptorSetCount - 
 * @param pDescriptorSets - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkFreeDescriptorSets0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   descriptorPool,
             int  descriptorSetCount,
             java.nio.ByteBuffer   pDescriptorSets);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkDescriptorPool* ptr_descriptorPool = (VkDescriptorPool*) descriptorPool;
     VkResult res = vkFreeDescriptorSets(
                     (VkDevice) (*ptr_device),
                     (VkDescriptorPool) (*ptr_descriptorPool),
                     (uint32_t) descriptorSetCount,
                     (const VkDescriptorSet*) pDescriptorSets);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 80
 * <h2>Prototype</h2><pre>
 *  void  vkUpdateDescriptorSets(
 *     VkDevice                                    device,
 *     uint32_t                                    descriptorWriteCount,
 *     const VkWriteDescriptorSet*                 pDescriptorWrites,
 *     uint32_t                                    descriptorCopyCount,
 *     const VkCopyDescriptorSet*                  pDescriptorCopies);
 * </pre>
 * 
 * @param device - 
 * @param descriptorWriteCount - 
 * @param pDescriptorWrites - 
 * @param descriptorCopyCount - 
 * @param pDescriptorCopies - 
 */
public void vkUpdateDescriptorSets(
             VkDevice device,
             int descriptorWriteCount,
              VkWriteDescriptorSet  pDescriptorWrites,
             int descriptorCopyCount,
              VkCopyDescriptorSet  pDescriptorCopies){
     vkUpdateDescriptorSets0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             descriptorWriteCount ,
             (pDescriptorWrites==null ? null : pDescriptorWrites.getPointerStruct()) /* ByteBuffer */ ,
             descriptorCopyCount ,
             (pDescriptorCopies==null ? null : pDescriptorCopies.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #80
 *  vkUpdateDescriptorSets 
 * 
 * @param device - 
 * @param descriptorWriteCount - 
 * @param pDescriptorWrites - 
 * @param descriptorCopyCount - 
 * @param pDescriptorCopies - 
 */
 private static native void vkUpdateDescriptorSets0(
             java.nio.ByteBuffer   device,
             int  descriptorWriteCount,
             java.nio.ByteBuffer   pDescriptorWrites,
             int  descriptorCopyCount,
             java.nio.ByteBuffer   pDescriptorCopies);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     vkUpdateDescriptorSets(
                     (VkDevice) (*ptr_device),
                     (uint32_t) descriptorWriteCount,
                     (const VkWriteDescriptorSet*) pDescriptorWrites,
                     (uint32_t) descriptorCopyCount,
                     (const VkCopyDescriptorSet*) pDescriptorCopies);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 81
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateFramebuffer(
 *     VkDevice                                    device,
 *     const VkFramebufferCreateInfo*              pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkFramebuffer*                              pFramebuffer);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pFramebuffer - 
 * 
 * @return VkResult
 */
public VkResult vkCreateFramebuffer(
             VkDevice device,
              VkFramebufferCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkFramebuffer  pFramebuffer){
     int  _val = vkCreateFramebuffer0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pFramebuffer==null ? null : pFramebuffer.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #81
 *  vkCreateFramebuffer 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pFramebuffer - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateFramebuffer0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pFramebuffer);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateFramebuffer(
                     (VkDevice) (*ptr_device),
                     (const VkFramebufferCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkFramebuffer*) pFramebuffer);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 82
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyFramebuffer(
 *     VkDevice                                    device,
 *     VkFramebuffer                               framebuffer,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param framebuffer - 
 * @param pAllocator - 
 */
public void vkDestroyFramebuffer(
             VkDevice device,
             VkFramebuffer framebuffer,
              VkAllocationCallbacks  pAllocator){
     vkDestroyFramebuffer0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (framebuffer==null ? null : framebuffer.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #82
 *  vkDestroyFramebuffer 
 * 
 * @param device - 
 * @param framebuffer - 
 * @param pAllocator - 
 */
 private static native void vkDestroyFramebuffer0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   framebuffer,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkFramebuffer* ptr_framebuffer = (VkFramebuffer*) framebuffer;
     vkDestroyFramebuffer(
                     (VkDevice) (*ptr_device),
                     (VkFramebuffer) (*ptr_framebuffer),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 83
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateRenderPass(
 *     VkDevice                                    device,
 *     const VkRenderPassCreateInfo*               pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkRenderPass*                               pRenderPass);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pRenderPass - 
 * 
 * @return VkResult
 */
public VkResult vkCreateRenderPass(
             VkDevice device,
              VkRenderPassCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkRenderPass  pRenderPass){
     int  _val = vkCreateRenderPass0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pRenderPass==null ? null : pRenderPass.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #83
 *  vkCreateRenderPass 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pRenderPass - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateRenderPass0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pRenderPass);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateRenderPass(
                     (VkDevice) (*ptr_device),
                     (const VkRenderPassCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkRenderPass*) pRenderPass);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 84
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyRenderPass(
 *     VkDevice                                    device,
 *     VkRenderPass                                renderPass,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param renderPass - 
 * @param pAllocator - 
 */
public void vkDestroyRenderPass(
             VkDevice device,
             VkRenderPass renderPass,
              VkAllocationCallbacks  pAllocator){
     vkDestroyRenderPass0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (renderPass==null ? null : renderPass.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #84
 *  vkDestroyRenderPass 
 * 
 * @param device - 
 * @param renderPass - 
 * @param pAllocator - 
 */
 private static native void vkDestroyRenderPass0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   renderPass,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkRenderPass* ptr_renderPass = (VkRenderPass*) renderPass;
     vkDestroyRenderPass(
                     (VkDevice) (*ptr_device),
                     (VkRenderPass) (*ptr_renderPass),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 85
 * <h2>Prototype</h2><pre>
 *  void  vkGetRenderAreaGranularity(
 *     VkDevice                                    device,
 *     VkRenderPass                                renderPass,
 *     VkExtent2D*                                 pGranularity);
 * </pre>
 * 
 * @param device - 
 * @param renderPass - 
 * @param pGranularity - 
 */
public void vkGetRenderAreaGranularity(
             VkDevice device,
             VkRenderPass renderPass,
              VkExtent2D  pGranularity){
     vkGetRenderAreaGranularity0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (renderPass==null ? null : renderPass.getHandle()) /* ByteBuffer */ ,
             (pGranularity==null ? null : pGranularity.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #85
 *  vkGetRenderAreaGranularity 
 * 
 * @param device - 
 * @param renderPass - 
 * @param pGranularity - 
 */
 private static native void vkGetRenderAreaGranularity0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   renderPass,
             java.nio.ByteBuffer   pGranularity);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkRenderPass* ptr_renderPass = (VkRenderPass*) renderPass;
     vkGetRenderAreaGranularity(
                     (VkDevice) (*ptr_device),
                     (VkRenderPass) (*ptr_renderPass),
                     (VkExtent2D*) pGranularity);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 86
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateCommandPool(
 *     VkDevice                                    device,
 *     const VkCommandPoolCreateInfo*              pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkCommandPool*                              pCommandPool);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pCommandPool - 
 * 
 * @return VkResult
 */
public VkResult vkCreateCommandPool(
              VkDevice device,
              VkCommandPoolCreateInfo  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkCommandPool[]  pCommandPool){
     int[] result = {0};
     ByteBuffer handle = vkCreateCommandPool0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     result );
     
      return VkResult.fromValue(result[0]);
} 

/**
 *  Native interface for Vulkan method #86
 *  vkCreateCommandPool 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pCommandPool - 
 * 
 * @return VkResult as int  
 */
 private static native ByteBuffer  vkCreateCommandPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             int[] result);/* 
             
     VkDevice* ptr_device = (VkDevice*) device;
     VkCommandPool* pCommandPool = NULL;
     
     VkResult res = vkCreateCommandPool(
                     (VkDevice) (*ptr_device),
                     (const VkCommandPoolCreateInfo*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkCommandPool*) pCommandPool);
                     
      result[0] = res;
      if(pCommandPool){
       jobject buffer = (jobject)(env->NewDirectByteBuffer(pCommandPool, sizeof(void*)));
       return buffer;
      }   
      return NULL;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 87
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyCommandPool(
 *     VkDevice                                    device,
 *     VkCommandPool                               commandPool,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param commandPool - 
 * @param pAllocator - 
 */
public void vkDestroyCommandPool(
             VkDevice device,
             VkCommandPool commandPool,
              VkAllocationCallbacks  pAllocator){
     vkDestroyCommandPool0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (commandPool==null ? null : commandPool.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #87
 *  vkDestroyCommandPool 
 * 
 * @param device - 
 * @param commandPool - 
 * @param pAllocator - 
 */
 private static native void vkDestroyCommandPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   commandPool,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkCommandPool* ptr_commandPool = (VkCommandPool*) commandPool;
     vkDestroyCommandPool(
                     (VkDevice) (*ptr_device),
                     (VkCommandPool) (*ptr_commandPool),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 88
 * <h2>Prototype</h2><pre>
 *  VkResult  vkResetCommandPool(
 *     VkDevice                                    device,
 *     VkCommandPool                               commandPool,
 *     VkCommandPoolResetFlags                     flags);
 * </pre>
 * 
 * @param device - 
 * @param commandPool - 
 * @param flags - 
 * 
 * @return VkResult
 */
public VkResult vkResetCommandPool(
             VkDevice device,
             VkCommandPool commandPool,
             int flags){
     int  _val = vkResetCommandPool0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (commandPool==null ? null : commandPool.getHandle()) /* ByteBuffer */ ,
                     flags  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #88
 *  vkResetCommandPool 
 * 
 * @param device - 
 * @param commandPool - 
 * @param flags - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkResetCommandPool0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   commandPool,
             int  flags);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkCommandPool* ptr_commandPool = (VkCommandPool*) commandPool;
     VkResult res = vkResetCommandPool(
                     (VkDevice) (*ptr_device),
                     (VkCommandPool) (*ptr_commandPool),
                     (VkCommandPoolResetFlags) flags);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 89
 * <h2>Prototype</h2><pre>
 *  VkResult  vkAllocateCommandBuffers(
 *     VkDevice                                    device,
 *     const VkCommandBufferAllocateInfo*          pAllocateInfo,
 *     VkCommandBuffer*                            pCommandBuffers);
 * </pre>
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pCommandBuffers - 
 * 
 * @return VkResult
 */
public VkResult vkAllocateCommandBuffers(
             VkDevice device,
              VkCommandBufferAllocateInfo  pAllocateInfo,
              VkCommandBuffer  pCommandBuffers){
     int  _val = vkAllocateCommandBuffers0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pAllocateInfo==null ? null : pAllocateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pCommandBuffers==null ? null : pCommandBuffers.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #89
 *  vkAllocateCommandBuffers 
 * 
 * @param device - 
 * @param pAllocateInfo - 
 * @param pCommandBuffers - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkAllocateCommandBuffers0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pAllocateInfo,
             java.nio.ByteBuffer   pCommandBuffers);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkAllocateCommandBuffers(
                     (VkDevice) (*ptr_device),
                     (const VkCommandBufferAllocateInfo*) pAllocateInfo,
                     (VkCommandBuffer*) pCommandBuffers);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 90
 * <h2>Prototype</h2><pre>
 *  void  vkFreeCommandBuffers(
 *     VkDevice                                    device,
 *     VkCommandPool                               commandPool,
 *     uint32_t                                    commandBufferCount,
 *     const VkCommandBuffer*                      pCommandBuffers);
 * </pre>
 * 
 * @param device - 
 * @param commandPool - 
 * @param commandBufferCount - 
 * @param pCommandBuffers - 
 */
public void vkFreeCommandBuffers(
             VkDevice device,
             VkCommandPool commandPool,
             int commandBufferCount,
              VkCommandBuffer  pCommandBuffers){
     vkFreeCommandBuffers0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (commandPool==null ? null : commandPool.getHandle()) /* ByteBuffer */ ,
             commandBufferCount ,
             (pCommandBuffers==null ? null : pCommandBuffers.getHandle()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #90
 *  vkFreeCommandBuffers 
 * 
 * @param device - 
 * @param commandPool - 
 * @param commandBufferCount - 
 * @param pCommandBuffers - 
 */
 private static native void vkFreeCommandBuffers0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   commandPool,
             int  commandBufferCount,
             java.nio.ByteBuffer   pCommandBuffers);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkCommandPool* ptr_commandPool = (VkCommandPool*) commandPool;
     vkFreeCommandBuffers(
                     (VkDevice) (*ptr_device),
                     (VkCommandPool) (*ptr_commandPool),
                     (uint32_t) commandBufferCount,
                     (const VkCommandBuffer*) pCommandBuffers);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 91
 * <h2>Prototype</h2><pre>
 *  VkResult  vkBeginCommandBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     const VkCommandBufferBeginInfo*             pBeginInfo);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param pBeginInfo - 
 * 
 * @return VkResult
 */
public VkResult vkBeginCommandBuffer(
             VkCommandBuffer commandBuffer,
              VkCommandBufferBeginInfo  pBeginInfo){
     int  _val = vkBeginCommandBuffer0(
                     (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
                     (pBeginInfo==null ? null : pBeginInfo.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #91
 *  vkBeginCommandBuffer 
 * 
 * @param commandBuffer - 
 * @param pBeginInfo - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkBeginCommandBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   pBeginInfo);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkResult res = vkBeginCommandBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (const VkCommandBufferBeginInfo*) pBeginInfo);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 92
 * <h2>Prototype</h2><pre>
 *  VkResult  vkEndCommandBuffer(
 *     VkCommandBuffer                             commandBuffer);
 * </pre>
 * 
 * @param commandBuffer - 
 * 
 * @return VkResult
 */
public VkResult vkEndCommandBuffer(
             VkCommandBuffer commandBuffer){
     int  _val = vkEndCommandBuffer0(
                     (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #92
 *  vkEndCommandBuffer 
 * 
 * @param commandBuffer - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkEndCommandBuffer0(
             java.nio.ByteBuffer   commandBuffer);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkResult res = vkEndCommandBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer));
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 93
 * <h2>Prototype</h2><pre>
 *  VkResult  vkResetCommandBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkCommandBufferResetFlags                   flags);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param flags - 
 * 
 * @return VkResult
 */
public VkResult vkResetCommandBuffer(
             VkCommandBuffer commandBuffer,
             int flags){
     int  _val = vkResetCommandBuffer0(
                     (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
                     flags  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #93
 *  vkResetCommandBuffer 
 * 
 * @param commandBuffer - 
 * @param flags - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkResetCommandBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             int  flags);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkResult res = vkResetCommandBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkCommandBufferResetFlags) flags);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 94
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBindPipeline(
 *     VkCommandBuffer                             commandBuffer,
 *     VkPipelineBindPoint                         pipelineBindPoint,
 *     VkPipeline                                  pipeline);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param pipelineBindPoint - 
 * @param pipeline - 
 */
public void vkCmdBindPipeline(
             VkCommandBuffer commandBuffer,
             VkPipelineBindPoint pipelineBindPoint,
             VkPipeline pipeline){
     vkCmdBindPipeline0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             pipelineBindPoint.getValue() /* enum */,
             (pipeline==null ? null : pipeline.getHandle()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #94
 *  vkCmdBindPipeline 
 * 
 * @param commandBuffer - 
 * @param pipelineBindPoint - 
 * @param pipeline - 
 */
 private static native void vkCmdBindPipeline0(
             java.nio.ByteBuffer   commandBuffer,
             int   pipelineBindPoint,
             java.nio.ByteBuffer   pipeline);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkPipeline* ptr_pipeline = (VkPipeline*) pipeline;
     vkCmdBindPipeline(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkPipelineBindPoint) pipelineBindPoint,
                     (VkPipeline) (*ptr_pipeline));

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 95
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetViewport(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    firstViewport,
 *     uint32_t                                    viewportCount,
 *     const VkViewport*                           pViewports);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param firstViewport - 
 * @param viewportCount - 
 * @param pViewports - 
 */
public void vkCmdSetViewport(
             VkCommandBuffer commandBuffer,
             int firstViewport,
             int viewportCount,
              VkViewport  pViewports){
     vkCmdSetViewport0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             firstViewport ,
             viewportCount ,
             (pViewports==null ? null : pViewports.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #95
 *  vkCmdSetViewport 
 * 
 * @param commandBuffer - 
 * @param firstViewport - 
 * @param viewportCount - 
 * @param pViewports - 
 */
 private static native void vkCmdSetViewport0(
             java.nio.ByteBuffer   commandBuffer,
             int  firstViewport,
             int  viewportCount,
             java.nio.ByteBuffer   pViewports);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetViewport(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) firstViewport,
                     (uint32_t) viewportCount,
                     (const VkViewport*) pViewports);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 96
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetScissor(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    firstScissor,
 *     uint32_t                                    scissorCount,
 *     const VkRect2D*                             pScissors);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param firstScissor - 
 * @param scissorCount - 
 * @param pScissors - 
 */
public void vkCmdSetScissor(
             VkCommandBuffer commandBuffer,
             int firstScissor,
             int scissorCount,
              VkRect2D  pScissors){
     vkCmdSetScissor0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             firstScissor ,
             scissorCount ,
             (pScissors==null ? null : pScissors.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #96
 *  vkCmdSetScissor 
 * 
 * @param commandBuffer - 
 * @param firstScissor - 
 * @param scissorCount - 
 * @param pScissors - 
 */
 private static native void vkCmdSetScissor0(
             java.nio.ByteBuffer   commandBuffer,
             int  firstScissor,
             int  scissorCount,
             java.nio.ByteBuffer   pScissors);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetScissor(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) firstScissor,
                     (uint32_t) scissorCount,
                     (const VkRect2D*) pScissors);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 97
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetLineWidth(
 *     VkCommandBuffer                             commandBuffer,
 *     float                                       lineWidth);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param lineWidth - 
 */
public void vkCmdSetLineWidth(
             VkCommandBuffer commandBuffer,
             float lineWidth){
     vkCmdSetLineWidth0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             lineWidth  );

} 

/**
 *  Native interface for Vulkan method #97
 *  vkCmdSetLineWidth 
 * 
 * @param commandBuffer - 
 * @param lineWidth - 
 */
 private static native void vkCmdSetLineWidth0(
             java.nio.ByteBuffer   commandBuffer,
             float  lineWidth);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetLineWidth(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (float) lineWidth);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 98
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetDepthBias(
 *     VkCommandBuffer                             commandBuffer,
 *     float                                       depthBiasConstantFactor,
 *     float                                       depthBiasClamp,
 *     float                                       depthBiasSlopeFactor);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param depthBiasConstantFactor - 
 * @param depthBiasClamp - 
 * @param depthBiasSlopeFactor - 
 */
public void vkCmdSetDepthBias(
             VkCommandBuffer commandBuffer,
             float depthBiasConstantFactor,
             float depthBiasClamp,
             float depthBiasSlopeFactor){
     vkCmdSetDepthBias0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             depthBiasConstantFactor ,
             depthBiasClamp ,
             depthBiasSlopeFactor  );

} 

/**
 *  Native interface for Vulkan method #98
 *  vkCmdSetDepthBias 
 * 
 * @param commandBuffer - 
 * @param depthBiasConstantFactor - 
 * @param depthBiasClamp - 
 * @param depthBiasSlopeFactor - 
 */
 private static native void vkCmdSetDepthBias0(
             java.nio.ByteBuffer   commandBuffer,
             float  depthBiasConstantFactor,
             float  depthBiasClamp,
             float  depthBiasSlopeFactor);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetDepthBias(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (float) depthBiasConstantFactor,
                     (float) depthBiasClamp,
                     (float) depthBiasSlopeFactor);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 99
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetBlendConstants(
 *     VkCommandBuffer                             commandBuffer,
 *     const float                                 blendConstants[4]);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param blendConstants - 
 */
public void vkCmdSetBlendConstants(
             VkCommandBuffer commandBuffer,
             float[] blendConstants){
     vkCmdSetBlendConstants0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             blendConstants  );

} 

/**
 *  Native interface for Vulkan method #99
 *  vkCmdSetBlendConstants 
 * 
 * @param commandBuffer - 
 * @param blendConstants - 
 */
 private static native void vkCmdSetBlendConstants0(
             java.nio.ByteBuffer   commandBuffer,
             float[]  blendConstants);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetBlendConstants(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     blendConstants);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 100
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetDepthBounds(
 *     VkCommandBuffer                             commandBuffer,
 *     float                                       minDepthBounds,
 *     float                                       maxDepthBounds);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param minDepthBounds - 
 * @param maxDepthBounds - 
 */
public void vkCmdSetDepthBounds(
             VkCommandBuffer commandBuffer,
             float minDepthBounds,
             float maxDepthBounds){
     vkCmdSetDepthBounds0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             minDepthBounds ,
             maxDepthBounds  );

} 

/**
 *  Native interface for Vulkan method #100
 *  vkCmdSetDepthBounds 
 * 
 * @param commandBuffer - 
 * @param minDepthBounds - 
 * @param maxDepthBounds - 
 */
 private static native void vkCmdSetDepthBounds0(
             java.nio.ByteBuffer   commandBuffer,
             float  minDepthBounds,
             float  maxDepthBounds);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetDepthBounds(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (float) minDepthBounds,
                     (float) maxDepthBounds);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 101
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetStencilCompareMask(
 *     VkCommandBuffer                             commandBuffer,
 *     VkStencilFaceFlags                          faceMask,
 *     uint32_t                                    compareMask);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param compareMask - 
 */
public void vkCmdSetStencilCompareMask(
             VkCommandBuffer commandBuffer,
             int faceMask,
             int compareMask){
     vkCmdSetStencilCompareMask0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             faceMask ,
             compareMask  );

} 

/**
 *  Native interface for Vulkan method #101
 *  vkCmdSetStencilCompareMask 
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param compareMask - 
 */
 private static native void vkCmdSetStencilCompareMask0(
             java.nio.ByteBuffer   commandBuffer,
             int  faceMask,
             int  compareMask);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetStencilCompareMask(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkStencilFaceFlags) faceMask,
                     (uint32_t) compareMask);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 102
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetStencilWriteMask(
 *     VkCommandBuffer                             commandBuffer,
 *     VkStencilFaceFlags                          faceMask,
 *     uint32_t                                    writeMask);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param writeMask - 
 */
public void vkCmdSetStencilWriteMask(
             VkCommandBuffer commandBuffer,
             int faceMask,
             int writeMask){
     vkCmdSetStencilWriteMask0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             faceMask ,
             writeMask  );

} 

/**
 *  Native interface for Vulkan method #102
 *  vkCmdSetStencilWriteMask 
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param writeMask - 
 */
 private static native void vkCmdSetStencilWriteMask0(
             java.nio.ByteBuffer   commandBuffer,
             int  faceMask,
             int  writeMask);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetStencilWriteMask(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkStencilFaceFlags) faceMask,
                     (uint32_t) writeMask);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 103
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetStencilReference(
 *     VkCommandBuffer                             commandBuffer,
 *     VkStencilFaceFlags                          faceMask,
 *     uint32_t                                    reference);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param reference - 
 */
public void vkCmdSetStencilReference(
             VkCommandBuffer commandBuffer,
             int faceMask,
             int reference){
     vkCmdSetStencilReference0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             faceMask ,
             reference  );

} 

/**
 *  Native interface for Vulkan method #103
 *  vkCmdSetStencilReference 
 * 
 * @param commandBuffer - 
 * @param faceMask - 
 * @param reference - 
 */
 private static native void vkCmdSetStencilReference0(
             java.nio.ByteBuffer   commandBuffer,
             int  faceMask,
             int  reference);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdSetStencilReference(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkStencilFaceFlags) faceMask,
                     (uint32_t) reference);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 104
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBindDescriptorSets(
 *     VkCommandBuffer                             commandBuffer,
 *     VkPipelineBindPoint                         pipelineBindPoint,
 *     VkPipelineLayout                            layout,
 *     uint32_t                                    firstSet,
 *     uint32_t                                    descriptorSetCount,
 *     const VkDescriptorSet*                      pDescriptorSets,
 *     uint32_t                                    dynamicOffsetCount,
 *     const uint32_t*                             pDynamicOffsets);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param pipelineBindPoint - 
 * @param layout - 
 * @param firstSet - 
 * @param descriptorSetCount - 
 * @param pDescriptorSets - 
 * @param dynamicOffsetCount - 
 * @param pDynamicOffsets - 
 */
public void vkCmdBindDescriptorSets(
             VkCommandBuffer commandBuffer,
             VkPipelineBindPoint pipelineBindPoint,
             VkPipelineLayout layout,
             int firstSet,
             int descriptorSetCount,
              VkDescriptorSet  pDescriptorSets,
             int dynamicOffsetCount,
             int[] pDynamicOffsets){
     vkCmdBindDescriptorSets0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             pipelineBindPoint.getValue() /* enum */,
             (layout==null ? null : layout.getHandle()) /* ByteBuffer */ ,
             firstSet ,
             descriptorSetCount ,
             (pDescriptorSets==null ? null : pDescriptorSets.getHandle()) /* ByteBuffer */ ,
             dynamicOffsetCount ,
             pDynamicOffsets  );

} 

/**
 *  Native interface for Vulkan method #104
 *  vkCmdBindDescriptorSets 
 * 
 * @param commandBuffer - 
 * @param pipelineBindPoint - 
 * @param layout - 
 * @param firstSet - 
 * @param descriptorSetCount - 
 * @param pDescriptorSets - 
 * @param dynamicOffsetCount - 
 * @param pDynamicOffsets - 
 */
 private static native void vkCmdBindDescriptorSets0(
             java.nio.ByteBuffer   commandBuffer,
             int   pipelineBindPoint,
             java.nio.ByteBuffer   layout,
             int  firstSet,
             int  descriptorSetCount,
             java.nio.ByteBuffer   pDescriptorSets,
             int  dynamicOffsetCount,
             int[]  pDynamicOffsets);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkPipelineLayout* ptr_layout = (VkPipelineLayout*) layout;
     vkCmdBindDescriptorSets(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkPipelineBindPoint) pipelineBindPoint,
                     (VkPipelineLayout) (*ptr_layout),
                     (uint32_t) firstSet,
                     (uint32_t) descriptorSetCount,
                     (const VkDescriptorSet*) pDescriptorSets,
                     (uint32_t) dynamicOffsetCount,
                     (const uint32_t*) pDynamicOffsets);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 105
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBindIndexBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    buffer,
 *     VkDeviceSize                                offset,
 *     VkIndexType                                 indexType);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param indexType - 
 */
public void vkCmdBindIndexBuffer(
             VkCommandBuffer commandBuffer,
             VkBuffer buffer,
             long offset,
             VkIndexType indexType){
     vkCmdBindIndexBuffer0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             offset ,
             indexType.getValue() /* enum */ );

} 

/**
 *  Native interface for Vulkan method #105
 *  vkCmdBindIndexBuffer 
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param indexType - 
 */
 private static native void vkCmdBindIndexBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   buffer,
             long  offset,
             int   indexType);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkCmdBindIndexBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_buffer),
                     (VkDeviceSize) offset,
                     (VkIndexType) indexType);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 106
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBindVertexBuffers(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    firstBinding,
 *     uint32_t                                    bindingCount,
 *     const VkBuffer*                             pBuffers,
 *     const VkDeviceSize*                         pOffsets);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param firstBinding - 
 * @param bindingCount - 
 * @param pBuffers - 
 * @param pOffsets - 
 */
public void vkCmdBindVertexBuffers(
             VkCommandBuffer commandBuffer,
             int firstBinding,
             int bindingCount,
              VkBuffer  pBuffers,
             long[] pOffsets){
     vkCmdBindVertexBuffers0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             firstBinding ,
             bindingCount ,
             (pBuffers==null ? null : pBuffers.getHandle()) /* ByteBuffer */ ,
             pOffsets  );

} 

/**
 *  Native interface for Vulkan method #106
 *  vkCmdBindVertexBuffers 
 * 
 * @param commandBuffer - 
 * @param firstBinding - 
 * @param bindingCount - 
 * @param pBuffers - 
 * @param pOffsets - 
 */
 private static native void vkCmdBindVertexBuffers0(
             java.nio.ByteBuffer   commandBuffer,
             int  firstBinding,
             int  bindingCount,
             java.nio.ByteBuffer   pBuffers,
             long[]  pOffsets);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdBindVertexBuffers(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) firstBinding,
                     (uint32_t) bindingCount,
                     (const VkBuffer*) pBuffers,
                     (const VkDeviceSize*) pOffsets);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 107
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDraw(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    vertexCount,
 *     uint32_t                                    instanceCount,
 *     uint32_t                                    firstVertex,
 *     uint32_t                                    firstInstance);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param vertexCount - 
 * @param instanceCount - 
 * @param firstVertex - 
 * @param firstInstance - 
 */
public void vkCmdDraw(
             VkCommandBuffer commandBuffer,
             int vertexCount,
             int instanceCount,
             int firstVertex,
             int firstInstance){
     vkCmdDraw0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             vertexCount ,
             instanceCount ,
             firstVertex ,
             firstInstance  );

} 

/**
 *  Native interface for Vulkan method #107
 *  vkCmdDraw 
 * 
 * @param commandBuffer - 
 * @param vertexCount - 
 * @param instanceCount - 
 * @param firstVertex - 
 * @param firstInstance - 
 */
 private static native void vkCmdDraw0(
             java.nio.ByteBuffer   commandBuffer,
             int  vertexCount,
             int  instanceCount,
             int  firstVertex,
             int  firstInstance);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdDraw(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) vertexCount,
                     (uint32_t) instanceCount,
                     (uint32_t) firstVertex,
                     (uint32_t) firstInstance);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 108
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDrawIndexed(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    indexCount,
 *     uint32_t                                    instanceCount,
 *     uint32_t                                    firstIndex,
 *     int32_t                                     vertexOffset,
 *     uint32_t                                    firstInstance);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param indexCount - 
 * @param instanceCount - 
 * @param firstIndex - 
 * @param vertexOffset - 
 * @param firstInstance - 
 */
public void vkCmdDrawIndexed(
             VkCommandBuffer commandBuffer,
             int indexCount,
             int instanceCount,
             int firstIndex,
             int vertexOffset,
             int firstInstance){
     vkCmdDrawIndexed0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             indexCount ,
             instanceCount ,
             firstIndex ,
             vertexOffset ,
             firstInstance  );

} 

/**
 *  Native interface for Vulkan method #108
 *  vkCmdDrawIndexed 
 * 
 * @param commandBuffer - 
 * @param indexCount - 
 * @param instanceCount - 
 * @param firstIndex - 
 * @param vertexOffset - 
 * @param firstInstance - 
 */
 private static native void vkCmdDrawIndexed0(
             java.nio.ByteBuffer   commandBuffer,
             int  indexCount,
             int  instanceCount,
             int  firstIndex,
             int  vertexOffset,
             int  firstInstance);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdDrawIndexed(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) indexCount,
                     (uint32_t) instanceCount,
                     (uint32_t) firstIndex,
                     (int32_t) vertexOffset,
                     (uint32_t) firstInstance);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 109
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDrawIndirect(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    buffer,
 *     VkDeviceSize                                offset,
 *     uint32_t                                    drawCount,
 *     uint32_t                                    stride);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param drawCount - 
 * @param stride - 
 */
public void vkCmdDrawIndirect(
             VkCommandBuffer commandBuffer,
             VkBuffer buffer,
             long offset,
             int drawCount,
             int stride){
     vkCmdDrawIndirect0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             offset ,
             drawCount ,
             stride  );

} 

/**
 *  Native interface for Vulkan method #109
 *  vkCmdDrawIndirect 
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param drawCount - 
 * @param stride - 
 */
 private static native void vkCmdDrawIndirect0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   buffer,
             long  offset,
             int  drawCount,
             int  stride);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkCmdDrawIndirect(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_buffer),
                     (VkDeviceSize) offset,
                     (uint32_t) drawCount,
                     (uint32_t) stride);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 110
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDrawIndexedIndirect(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    buffer,
 *     VkDeviceSize                                offset,
 *     uint32_t                                    drawCount,
 *     uint32_t                                    stride);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param drawCount - 
 * @param stride - 
 */
public void vkCmdDrawIndexedIndirect(
             VkCommandBuffer commandBuffer,
             VkBuffer buffer,
             long offset,
             int drawCount,
             int stride){
     vkCmdDrawIndexedIndirect0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             offset ,
             drawCount ,
             stride  );

} 

/**
 *  Native interface for Vulkan method #110
 *  vkCmdDrawIndexedIndirect 
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 * @param drawCount - 
 * @param stride - 
 */
 private static native void vkCmdDrawIndexedIndirect0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   buffer,
             long  offset,
             int  drawCount,
             int  stride);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkCmdDrawIndexedIndirect(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_buffer),
                     (VkDeviceSize) offset,
                     (uint32_t) drawCount,
                     (uint32_t) stride);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 111
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDispatch(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    x,
 *     uint32_t                                    y,
 *     uint32_t                                    z);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param x - 
 * @param y - 
 * @param z - 
 */
public void vkCmdDispatch(
             VkCommandBuffer commandBuffer,
             int x,
             int y,
             int z){
     vkCmdDispatch0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             x ,
             y ,
             z  );

} 

/**
 *  Native interface for Vulkan method #111
 *  vkCmdDispatch 
 * 
 * @param commandBuffer - 
 * @param x - 
 * @param y - 
 * @param z - 
 */
 private static native void vkCmdDispatch0(
             java.nio.ByteBuffer   commandBuffer,
             int  x,
             int  y,
             int  z);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdDispatch(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) x,
                     (uint32_t) y,
                     (uint32_t) z);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 112
 * <h2>Prototype</h2><pre>
 *  void  vkCmdDispatchIndirect(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    buffer,
 *     VkDeviceSize                                offset);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 */
public void vkCmdDispatchIndirect(
             VkCommandBuffer commandBuffer,
             VkBuffer buffer,
             long offset){
     vkCmdDispatchIndirect0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (buffer==null ? null : buffer.getHandle()) /* ByteBuffer */ ,
             offset  );

} 

/**
 *  Native interface for Vulkan method #112
 *  vkCmdDispatchIndirect 
 * 
 * @param commandBuffer - 
 * @param buffer - 
 * @param offset - 
 */
 private static native void vkCmdDispatchIndirect0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   buffer,
             long  offset);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_buffer = (VkBuffer*) buffer;
     vkCmdDispatchIndirect(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_buffer),
                     (VkDeviceSize) offset);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 113
 * <h2>Prototype</h2><pre>
 *  void  vkCmdCopyBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    srcBuffer,
 *     VkBuffer                                    dstBuffer,
 *     uint32_t                                    regionCount,
 *     const VkBufferCopy*                         pRegions);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcBuffer - 
 * @param dstBuffer - 
 * @param regionCount - 
 * @param pRegions - 
 */
public void vkCmdCopyBuffer(
             VkCommandBuffer commandBuffer,
             VkBuffer srcBuffer,
             VkBuffer dstBuffer,
             int regionCount,
              VkBufferCopy  pRegions){
     vkCmdCopyBuffer0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcBuffer==null ? null : srcBuffer.getHandle()) /* ByteBuffer */ ,
             (dstBuffer==null ? null : dstBuffer.getHandle()) /* ByteBuffer */ ,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #113
 *  vkCmdCopyBuffer 
 * 
 * @param commandBuffer - 
 * @param srcBuffer - 
 * @param dstBuffer - 
 * @param regionCount - 
 * @param pRegions - 
 */
 private static native void vkCmdCopyBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcBuffer,
             java.nio.ByteBuffer   dstBuffer,
             int  regionCount,
             java.nio.ByteBuffer   pRegions);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_srcBuffer = (VkBuffer*) srcBuffer;
     VkBuffer* ptr_dstBuffer = (VkBuffer*) dstBuffer;
     vkCmdCopyBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_srcBuffer),
                     (VkBuffer) (*ptr_dstBuffer),
                     (uint32_t) regionCount,
                     (const VkBufferCopy*) pRegions);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 114
 * <h2>Prototype</h2><pre>
 *  void  vkCmdCopyImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     srcImage,
 *     VkImageLayout                               srcImageLayout,
 *     VkImage                                     dstImage,
 *     VkImageLayout                               dstImageLayout,
 *     uint32_t                                    regionCount,
 *     const VkImageCopy*                          pRegions);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
public void vkCmdCopyImage(
             VkCommandBuffer commandBuffer,
             VkImage srcImage,
             VkImageLayout srcImageLayout,
             VkImage dstImage,
             VkImageLayout dstImageLayout,
             int regionCount,
              VkImageCopy  pRegions){
     vkCmdCopyImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcImage==null ? null : srcImage.getHandle()) /* ByteBuffer */ ,
             srcImageLayout.getValue() /* enum */,
             (dstImage==null ? null : dstImage.getHandle()) /* ByteBuffer */ ,
             dstImageLayout.getValue() /* enum */,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #114
 *  vkCmdCopyImage 
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
 private static native void vkCmdCopyImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcImage,
             int   srcImageLayout,
             java.nio.ByteBuffer   dstImage,
             int   dstImageLayout,
             int  regionCount,
             java.nio.ByteBuffer   pRegions);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_srcImage = (VkImage*) srcImage;
     VkImage* ptr_dstImage = (VkImage*) dstImage;
     vkCmdCopyImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_srcImage),
                     (VkImageLayout) srcImageLayout,
                     (VkImage) (*ptr_dstImage),
                     (VkImageLayout) dstImageLayout,
                     (uint32_t) regionCount,
                     (const VkImageCopy*) pRegions);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 115
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBlitImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     srcImage,
 *     VkImageLayout                               srcImageLayout,
 *     VkImage                                     dstImage,
 *     VkImageLayout                               dstImageLayout,
 *     uint32_t                                    regionCount,
 *     const VkImageBlit*                          pRegions,
 *     VkFilter                                    filter);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 * @param filter - 
 */
public void vkCmdBlitImage(
             VkCommandBuffer commandBuffer,
             VkImage srcImage,
             VkImageLayout srcImageLayout,
             VkImage dstImage,
             VkImageLayout dstImageLayout,
             int regionCount,
              VkImageBlit  pRegions,
             VkFilter filter){
     vkCmdBlitImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcImage==null ? null : srcImage.getHandle()) /* ByteBuffer */ ,
             srcImageLayout.getValue() /* enum */,
             (dstImage==null ? null : dstImage.getHandle()) /* ByteBuffer */ ,
             dstImageLayout.getValue() /* enum */,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */ ,
             filter.getValue() /* enum */ );

} 

/**
 *  Native interface for Vulkan method #115
 *  vkCmdBlitImage 
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 * @param filter - 
 */
 private static native void vkCmdBlitImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcImage,
             int   srcImageLayout,
             java.nio.ByteBuffer   dstImage,
             int   dstImageLayout,
             int  regionCount,
             java.nio.ByteBuffer   pRegions,
             int   filter);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_srcImage = (VkImage*) srcImage;
     VkImage* ptr_dstImage = (VkImage*) dstImage;
     vkCmdBlitImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_srcImage),
                     (VkImageLayout) srcImageLayout,
                     (VkImage) (*ptr_dstImage),
                     (VkImageLayout) dstImageLayout,
                     (uint32_t) regionCount,
                     (const VkImageBlit*) pRegions,
                     (VkFilter) filter);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 116
 * <h2>Prototype</h2><pre>
 *  void  vkCmdCopyBufferToImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    srcBuffer,
 *     VkImage                                     dstImage,
 *     VkImageLayout                               dstImageLayout,
 *     uint32_t                                    regionCount,
 *     const VkBufferImageCopy*                    pRegions);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcBuffer - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
public void vkCmdCopyBufferToImage(
             VkCommandBuffer commandBuffer,
             VkBuffer srcBuffer,
             VkImage dstImage,
             VkImageLayout dstImageLayout,
             int regionCount,
              VkBufferImageCopy  pRegions){
     vkCmdCopyBufferToImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcBuffer==null ? null : srcBuffer.getHandle()) /* ByteBuffer */ ,
             (dstImage==null ? null : dstImage.getHandle()) /* ByteBuffer */ ,
             dstImageLayout.getValue() /* enum */,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #116
 *  vkCmdCopyBufferToImage 
 * 
 * @param commandBuffer - 
 * @param srcBuffer - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
 private static native void vkCmdCopyBufferToImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcBuffer,
             java.nio.ByteBuffer   dstImage,
             int   dstImageLayout,
             int  regionCount,
             java.nio.ByteBuffer   pRegions);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_srcBuffer = (VkBuffer*) srcBuffer;
     VkImage* ptr_dstImage = (VkImage*) dstImage;
     vkCmdCopyBufferToImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_srcBuffer),
                     (VkImage) (*ptr_dstImage),
                     (VkImageLayout) dstImageLayout,
                     (uint32_t) regionCount,
                     (const VkBufferImageCopy*) pRegions);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 117
 * <h2>Prototype</h2><pre>
 *  void  vkCmdCopyImageToBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     srcImage,
 *     VkImageLayout                               srcImageLayout,
 *     VkBuffer                                    dstBuffer,
 *     uint32_t                                    regionCount,
 *     const VkBufferImageCopy*                    pRegions);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstBuffer - 
 * @param regionCount - 
 * @param pRegions - 
 */
public void vkCmdCopyImageToBuffer(
             VkCommandBuffer commandBuffer,
             VkImage srcImage,
             VkImageLayout srcImageLayout,
             VkBuffer dstBuffer,
             int regionCount,
              VkBufferImageCopy  pRegions){
     vkCmdCopyImageToBuffer0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcImage==null ? null : srcImage.getHandle()) /* ByteBuffer */ ,
             srcImageLayout.getValue() /* enum */,
             (dstBuffer==null ? null : dstBuffer.getHandle()) /* ByteBuffer */ ,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #117
 *  vkCmdCopyImageToBuffer 
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstBuffer - 
 * @param regionCount - 
 * @param pRegions - 
 */
 private static native void vkCmdCopyImageToBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcImage,
             int   srcImageLayout,
             java.nio.ByteBuffer   dstBuffer,
             int  regionCount,
             java.nio.ByteBuffer   pRegions);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_srcImage = (VkImage*) srcImage;
     VkBuffer* ptr_dstBuffer = (VkBuffer*) dstBuffer;
     vkCmdCopyImageToBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_srcImage),
                     (VkImageLayout) srcImageLayout,
                     (VkBuffer) (*ptr_dstBuffer),
                     (uint32_t) regionCount,
                     (const VkBufferImageCopy*) pRegions);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 118
 * <h2>Prototype</h2><pre>
 *  void  vkCmdUpdateBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    dstBuffer,
 *     VkDeviceSize                                dstOffset,
 *     VkDeviceSize                                dataSize,
 *     const uint32_t*                             pData);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param dataSize - 
 * @param pData - 
 */
public void vkCmdUpdateBuffer(
             VkCommandBuffer commandBuffer,
             VkBuffer dstBuffer,
             long dstOffset,
             long dataSize,
             int[] pData){
     vkCmdUpdateBuffer0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (dstBuffer==null ? null : dstBuffer.getHandle()) /* ByteBuffer */ ,
             dstOffset ,
             dataSize ,
             pData  );

} 

/**
 *  Native interface for Vulkan method #118
 *  vkCmdUpdateBuffer 
 * 
 * @param commandBuffer - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param dataSize - 
 * @param pData - 
 */
 private static native void vkCmdUpdateBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   dstBuffer,
             long  dstOffset,
             long  dataSize,
             int[]  pData);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_dstBuffer = (VkBuffer*) dstBuffer;
     vkCmdUpdateBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_dstBuffer),
                     (VkDeviceSize) dstOffset,
                     (VkDeviceSize) dataSize,
                     (const uint32_t*) pData);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 119
 * <h2>Prototype</h2><pre>
 *  void  vkCmdFillBuffer(
 *     VkCommandBuffer                             commandBuffer,
 *     VkBuffer                                    dstBuffer,
 *     VkDeviceSize                                dstOffset,
 *     VkDeviceSize                                size,
 *     uint32_t                                    data);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param size - 
 * @param data - 
 */
public void vkCmdFillBuffer(
             VkCommandBuffer commandBuffer,
             VkBuffer dstBuffer,
             long dstOffset,
             long size,
             int data){
     vkCmdFillBuffer0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (dstBuffer==null ? null : dstBuffer.getHandle()) /* ByteBuffer */ ,
             dstOffset ,
             size ,
             data  );

} 

/**
 *  Native interface for Vulkan method #119
 *  vkCmdFillBuffer 
 * 
 * @param commandBuffer - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param size - 
 * @param data - 
 */
 private static native void vkCmdFillBuffer0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   dstBuffer,
             long  dstOffset,
             long  size,
             int  data);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkBuffer* ptr_dstBuffer = (VkBuffer*) dstBuffer;
     vkCmdFillBuffer(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkBuffer) (*ptr_dstBuffer),
                     (VkDeviceSize) dstOffset,
                     (VkDeviceSize) size,
                     (uint32_t) data);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 120
 * <h2>Prototype</h2><pre>
 *  void  vkCmdClearColorImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     image,
 *     VkImageLayout                               imageLayout,
 *     const VkClearColorValue*                    pColor,
 *     uint32_t                                    rangeCount,
 *     const VkImageSubresourceRange*              pRanges);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param image - 
 * @param imageLayout - 
 * @param pColor - 
 * @param rangeCount - 
 * @param pRanges - 
 */
public void vkCmdClearColorImage(
             VkCommandBuffer commandBuffer,
             VkImage image,
             VkImageLayout imageLayout,
              VkClearColorValue  pColor,
             int rangeCount,
              VkImageSubresourceRange  pRanges){
     vkCmdClearColorImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             imageLayout.getValue() /* enum */,
             (pColor==null ? null : pColor.getPointerStruct()) /* ByteBuffer */ ,
             rangeCount ,
             (pRanges==null ? null : pRanges.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #120
 *  vkCmdClearColorImage 
 * 
 * @param commandBuffer - 
 * @param image - 
 * @param imageLayout - 
 * @param pColor - 
 * @param rangeCount - 
 * @param pRanges - 
 */
 private static native void vkCmdClearColorImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   image,
             int   imageLayout,
             java.nio.ByteBuffer   pColor,
             int  rangeCount,
             java.nio.ByteBuffer   pRanges);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_image = (VkImage*) image;
     vkCmdClearColorImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_image),
                     (VkImageLayout) imageLayout,
                     (const VkClearColorValue*) pColor,
                     (uint32_t) rangeCount,
                     (const VkImageSubresourceRange*) pRanges);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 121
 * <h2>Prototype</h2><pre>
 *  void  vkCmdClearDepthStencilImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     image,
 *     VkImageLayout                               imageLayout,
 *     const VkClearDepthStencilValue*             pDepthStencil,
 *     uint32_t                                    rangeCount,
 *     const VkImageSubresourceRange*              pRanges);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param image - 
 * @param imageLayout - 
 * @param pDepthStencil - 
 * @param rangeCount - 
 * @param pRanges - 
 */
public void vkCmdClearDepthStencilImage(
             VkCommandBuffer commandBuffer,
             VkImage image,
             VkImageLayout imageLayout,
              VkClearDepthStencilValue  pDepthStencil,
             int rangeCount,
              VkImageSubresourceRange  pRanges){
     vkCmdClearDepthStencilImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (image==null ? null : image.getHandle()) /* ByteBuffer */ ,
             imageLayout.getValue() /* enum */,
             (pDepthStencil==null ? null : pDepthStencil.getPointerStruct()) /* ByteBuffer */ ,
             rangeCount ,
             (pRanges==null ? null : pRanges.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #121
 *  vkCmdClearDepthStencilImage 
 * 
 * @param commandBuffer - 
 * @param image - 
 * @param imageLayout - 
 * @param pDepthStencil - 
 * @param rangeCount - 
 * @param pRanges - 
 */
 private static native void vkCmdClearDepthStencilImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   image,
             int   imageLayout,
             java.nio.ByteBuffer   pDepthStencil,
             int  rangeCount,
             java.nio.ByteBuffer   pRanges);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_image = (VkImage*) image;
     vkCmdClearDepthStencilImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_image),
                     (VkImageLayout) imageLayout,
                     (const VkClearDepthStencilValue*) pDepthStencil,
                     (uint32_t) rangeCount,
                     (const VkImageSubresourceRange*) pRanges);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 122
 * <h2>Prototype</h2><pre>
 *  void  vkCmdClearAttachments(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    attachmentCount,
 *     const VkClearAttachment*                    pAttachments,
 *     uint32_t                                    rectCount,
 *     const VkClearRect*                          pRects);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param attachmentCount - 
 * @param pAttachments - 
 * @param rectCount - 
 * @param pRects - 
 */
public void vkCmdClearAttachments(
             VkCommandBuffer commandBuffer,
             int attachmentCount,
              VkClearAttachment  pAttachments,
             int rectCount,
              VkClearRect  pRects){
     vkCmdClearAttachments0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             attachmentCount ,
             (pAttachments==null ? null : pAttachments.getPointerStruct()) /* ByteBuffer */ ,
             rectCount ,
             (pRects==null ? null : pRects.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #122
 *  vkCmdClearAttachments 
 * 
 * @param commandBuffer - 
 * @param attachmentCount - 
 * @param pAttachments - 
 * @param rectCount - 
 * @param pRects - 
 */
 private static native void vkCmdClearAttachments0(
             java.nio.ByteBuffer   commandBuffer,
             int  attachmentCount,
             java.nio.ByteBuffer   pAttachments,
             int  rectCount,
             java.nio.ByteBuffer   pRects);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdClearAttachments(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) attachmentCount,
                     (const VkClearAttachment*) pAttachments,
                     (uint32_t) rectCount,
                     (const VkClearRect*) pRects);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 123
 * <h2>Prototype</h2><pre>
 *  void  vkCmdResolveImage(
 *     VkCommandBuffer                             commandBuffer,
 *     VkImage                                     srcImage,
 *     VkImageLayout                               srcImageLayout,
 *     VkImage                                     dstImage,
 *     VkImageLayout                               dstImageLayout,
 *     uint32_t                                    regionCount,
 *     const VkImageResolve*                       pRegions);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
public void vkCmdResolveImage(
             VkCommandBuffer commandBuffer,
             VkImage srcImage,
             VkImageLayout srcImageLayout,
             VkImage dstImage,
             VkImageLayout dstImageLayout,
             int regionCount,
              VkImageResolve  pRegions){
     vkCmdResolveImage0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (srcImage==null ? null : srcImage.getHandle()) /* ByteBuffer */ ,
             srcImageLayout.getValue() /* enum */,
             (dstImage==null ? null : dstImage.getHandle()) /* ByteBuffer */ ,
             dstImageLayout.getValue() /* enum */,
             regionCount ,
             (pRegions==null ? null : pRegions.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #123
 *  vkCmdResolveImage 
 * 
 * @param commandBuffer - 
 * @param srcImage - 
 * @param srcImageLayout - 
 * @param dstImage - 
 * @param dstImageLayout - 
 * @param regionCount - 
 * @param pRegions - 
 */
 private static native void vkCmdResolveImage0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   srcImage,
             int   srcImageLayout,
             java.nio.ByteBuffer   dstImage,
             int   dstImageLayout,
             int  regionCount,
             java.nio.ByteBuffer   pRegions);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkImage* ptr_srcImage = (VkImage*) srcImage;
     VkImage* ptr_dstImage = (VkImage*) dstImage;
     vkCmdResolveImage(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkImage) (*ptr_srcImage),
                     (VkImageLayout) srcImageLayout,
                     (VkImage) (*ptr_dstImage),
                     (VkImageLayout) dstImageLayout,
                     (uint32_t) regionCount,
                     (const VkImageResolve*) pRegions);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 124
 * <h2>Prototype</h2><pre>
 *  void  vkCmdSetEvent(
 *     VkCommandBuffer                             commandBuffer,
 *     VkEvent                                     event,
 *     VkPipelineStageFlags                        stageMask);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param event - 
 * @param stageMask - 
 */
public void vkCmdSetEvent(
             VkCommandBuffer commandBuffer,
             VkEvent event,
             int stageMask){
     vkCmdSetEvent0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (event==null ? null : event.getHandle()) /* ByteBuffer */ ,
             stageMask  );

} 

/**
 *  Native interface for Vulkan method #124
 *  vkCmdSetEvent 
 * 
 * @param commandBuffer - 
 * @param event - 
 * @param stageMask - 
 */
 private static native void vkCmdSetEvent0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   event,
             int  stageMask);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkEvent* ptr_event = (VkEvent*) event;
     vkCmdSetEvent(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkEvent) (*ptr_event),
                     (VkPipelineStageFlags) stageMask);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 125
 * <h2>Prototype</h2><pre>
 *  void  vkCmdResetEvent(
 *     VkCommandBuffer                             commandBuffer,
 *     VkEvent                                     event,
 *     VkPipelineStageFlags                        stageMask);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param event - 
 * @param stageMask - 
 */
public void vkCmdResetEvent(
             VkCommandBuffer commandBuffer,
             VkEvent event,
             int stageMask){
     vkCmdResetEvent0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (event==null ? null : event.getHandle()) /* ByteBuffer */ ,
             stageMask  );

} 

/**
 *  Native interface for Vulkan method #125
 *  vkCmdResetEvent 
 * 
 * @param commandBuffer - 
 * @param event - 
 * @param stageMask - 
 */
 private static native void vkCmdResetEvent0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   event,
             int  stageMask);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkEvent* ptr_event = (VkEvent*) event;
     vkCmdResetEvent(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkEvent) (*ptr_event),
                     (VkPipelineStageFlags) stageMask);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 126
 * <h2>Prototype</h2><pre>
 *  void  vkCmdWaitEvents(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    eventCount,
 *     const VkEvent*                              pEvents,
 *     VkPipelineStageFlags                        srcStageMask,
 *     VkPipelineStageFlags                        dstStageMask,
 *     uint32_t                                    memoryBarrierCount,
 *     const VkMemoryBarrier*                      pMemoryBarriers,
 *     uint32_t                                    bufferMemoryBarrierCount,
 *     const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
 *     uint32_t                                    imageMemoryBarrierCount,
 *     const VkImageMemoryBarrier*                 pImageMemoryBarriers);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param eventCount - 
 * @param pEvents - 
 * @param srcStageMask - 
 * @param dstStageMask - 
 * @param memoryBarrierCount - 
 * @param pMemoryBarriers - 
 * @param bufferMemoryBarrierCount - 
 * @param pBufferMemoryBarriers - 
 * @param imageMemoryBarrierCount - 
 * @param pImageMemoryBarriers - 
 */
public void vkCmdWaitEvents(
             VkCommandBuffer commandBuffer,
             int eventCount,
              VkEvent  pEvents,
             int srcStageMask,
             int dstStageMask,
             int memoryBarrierCount,
              VkMemoryBarrier  pMemoryBarriers,
             int bufferMemoryBarrierCount,
              VkBufferMemoryBarrier  pBufferMemoryBarriers,
             int imageMemoryBarrierCount,
              VkImageMemoryBarrier  pImageMemoryBarriers){
     vkCmdWaitEvents0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             eventCount ,
             (pEvents==null ? null : pEvents.getHandle()) /* ByteBuffer */ ,
             srcStageMask ,
             dstStageMask ,
             memoryBarrierCount ,
             (pMemoryBarriers==null ? null : pMemoryBarriers.getPointerStruct()) /* ByteBuffer */ ,
             bufferMemoryBarrierCount ,
             (pBufferMemoryBarriers==null ? null : pBufferMemoryBarriers.getPointerStruct()) /* ByteBuffer */ ,
             imageMemoryBarrierCount ,
             (pImageMemoryBarriers==null ? null : pImageMemoryBarriers.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #126
 *  vkCmdWaitEvents 
 * 
 * @param commandBuffer - 
 * @param eventCount - 
 * @param pEvents - 
 * @param srcStageMask - 
 * @param dstStageMask - 
 * @param memoryBarrierCount - 
 * @param pMemoryBarriers - 
 * @param bufferMemoryBarrierCount - 
 * @param pBufferMemoryBarriers - 
 * @param imageMemoryBarrierCount - 
 * @param pImageMemoryBarriers - 
 */
 private static native void vkCmdWaitEvents0(
             java.nio.ByteBuffer   commandBuffer,
             int  eventCount,
             java.nio.ByteBuffer   pEvents,
             int  srcStageMask,
             int  dstStageMask,
             int  memoryBarrierCount,
             java.nio.ByteBuffer   pMemoryBarriers,
             int  bufferMemoryBarrierCount,
             java.nio.ByteBuffer   pBufferMemoryBarriers,
             int  imageMemoryBarrierCount,
             java.nio.ByteBuffer   pImageMemoryBarriers);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdWaitEvents(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) eventCount,
                     (const VkEvent*) pEvents,
                     (VkPipelineStageFlags) srcStageMask,
                     (VkPipelineStageFlags) dstStageMask,
                     (uint32_t) memoryBarrierCount,
                     (const VkMemoryBarrier*) pMemoryBarriers,
                     (uint32_t) bufferMemoryBarrierCount,
                     (const VkBufferMemoryBarrier*) pBufferMemoryBarriers,
                     (uint32_t) imageMemoryBarrierCount,
                     (const VkImageMemoryBarrier*) pImageMemoryBarriers);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 127
 * <h2>Prototype</h2><pre>
 *  void  vkCmdPipelineBarrier(
 *     VkCommandBuffer                             commandBuffer,
 *     VkPipelineStageFlags                        srcStageMask,
 *     VkPipelineStageFlags                        dstStageMask,
 *     VkDependencyFlags                           dependencyFlags,
 *     uint32_t                                    memoryBarrierCount,
 *     const VkMemoryBarrier*                      pMemoryBarriers,
 *     uint32_t                                    bufferMemoryBarrierCount,
 *     const VkBufferMemoryBarrier*                pBufferMemoryBarriers,
 *     uint32_t                                    imageMemoryBarrierCount,
 *     const VkImageMemoryBarrier*                 pImageMemoryBarriers);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param srcStageMask - 
 * @param dstStageMask - 
 * @param dependencyFlags - 
 * @param memoryBarrierCount - 
 * @param pMemoryBarriers - 
 * @param bufferMemoryBarrierCount - 
 * @param pBufferMemoryBarriers - 
 * @param imageMemoryBarrierCount - 
 * @param pImageMemoryBarriers - 
 */
public void vkCmdPipelineBarrier(
             VkCommandBuffer commandBuffer,
             int srcStageMask,
             int dstStageMask,
             int dependencyFlags,
             int memoryBarrierCount,
              VkMemoryBarrier  pMemoryBarriers,
             int bufferMemoryBarrierCount,
              VkBufferMemoryBarrier  pBufferMemoryBarriers,
             int imageMemoryBarrierCount,
              VkImageMemoryBarrier  pImageMemoryBarriers){
     vkCmdPipelineBarrier0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             srcStageMask ,
             dstStageMask ,
             dependencyFlags ,
             memoryBarrierCount ,
             (pMemoryBarriers==null ? null : pMemoryBarriers.getPointerStruct()) /* ByteBuffer */ ,
             bufferMemoryBarrierCount ,
             (pBufferMemoryBarriers==null ? null : pBufferMemoryBarriers.getPointerStruct()) /* ByteBuffer */ ,
             imageMemoryBarrierCount ,
             (pImageMemoryBarriers==null ? null : pImageMemoryBarriers.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #127
 *  vkCmdPipelineBarrier 
 * 
 * @param commandBuffer - 
 * @param srcStageMask - 
 * @param dstStageMask - 
 * @param dependencyFlags - 
 * @param memoryBarrierCount - 
 * @param pMemoryBarriers - 
 * @param bufferMemoryBarrierCount - 
 * @param pBufferMemoryBarriers - 
 * @param imageMemoryBarrierCount - 
 * @param pImageMemoryBarriers - 
 */
 private static native void vkCmdPipelineBarrier0(
             java.nio.ByteBuffer   commandBuffer,
             int  srcStageMask,
             int  dstStageMask,
             int  dependencyFlags,
             int  memoryBarrierCount,
             java.nio.ByteBuffer   pMemoryBarriers,
             int  bufferMemoryBarrierCount,
             java.nio.ByteBuffer   pBufferMemoryBarriers,
             int  imageMemoryBarrierCount,
             java.nio.ByteBuffer   pImageMemoryBarriers);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdPipelineBarrier(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkPipelineStageFlags) srcStageMask,
                     (VkPipelineStageFlags) dstStageMask,
                     (VkDependencyFlags) dependencyFlags,
                     (uint32_t) memoryBarrierCount,
                     (const VkMemoryBarrier*) pMemoryBarriers,
                     (uint32_t) bufferMemoryBarrierCount,
                     (const VkBufferMemoryBarrier*) pBufferMemoryBarriers,
                     (uint32_t) imageMemoryBarrierCount,
                     (const VkImageMemoryBarrier*) pImageMemoryBarriers);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 128
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBeginQuery(
 *     VkCommandBuffer                             commandBuffer,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    query,
 *     VkQueryControlFlags                         flags);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param query - 
 * @param flags - 
 */
public void vkCmdBeginQuery(
             VkCommandBuffer commandBuffer,
             VkQueryPool queryPool,
             int query,
             int flags){
     vkCmdBeginQuery0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             query ,
             flags  );

} 

/**
 *  Native interface for Vulkan method #128
 *  vkCmdBeginQuery 
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param query - 
 * @param flags - 
 */
 private static native void vkCmdBeginQuery0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   queryPool,
             int  query,
             int  flags);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     vkCmdBeginQuery(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) query,
                     (VkQueryControlFlags) flags);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 129
 * <h2>Prototype</h2><pre>
 *  void  vkCmdEndQuery(
 *     VkCommandBuffer                             commandBuffer,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    query);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param query - 
 */
public void vkCmdEndQuery(
             VkCommandBuffer commandBuffer,
             VkQueryPool queryPool,
             int query){
     vkCmdEndQuery0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             query  );

} 

/**
 *  Native interface for Vulkan method #129
 *  vkCmdEndQuery 
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param query - 
 */
 private static native void vkCmdEndQuery0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   queryPool,
             int  query);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     vkCmdEndQuery(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) query);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 130
 * <h2>Prototype</h2><pre>
 *  void  vkCmdResetQueryPool(
 *     VkCommandBuffer                             commandBuffer,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    firstQuery,
 *     uint32_t                                    queryCount);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 */
public void vkCmdResetQueryPool(
             VkCommandBuffer commandBuffer,
             VkQueryPool queryPool,
             int firstQuery,
             int queryCount){
     vkCmdResetQueryPool0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             firstQuery ,
             queryCount  );

} 

/**
 *  Native interface for Vulkan method #130
 *  vkCmdResetQueryPool 
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 */
 private static native void vkCmdResetQueryPool0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   queryPool,
             int  firstQuery,
             int  queryCount);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     vkCmdResetQueryPool(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) firstQuery,
                     (uint32_t) queryCount);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 131
 * <h2>Prototype</h2><pre>
 *  void  vkCmdWriteTimestamp(
 *     VkCommandBuffer                             commandBuffer,
 *     VkPipelineStageFlagBits                     pipelineStage,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    query);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param pipelineStage - 
 * @param queryPool - 
 * @param query - 
 */
public void vkCmdWriteTimestamp(
             VkCommandBuffer commandBuffer,
             VkPipelineStageFlagBits pipelineStage,
             VkQueryPool queryPool,
             int query){
     vkCmdWriteTimestamp0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             pipelineStage.getValue() /* enum */,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             query  );

} 

/**
 *  Native interface for Vulkan method #131
 *  vkCmdWriteTimestamp 
 * 
 * @param commandBuffer - 
 * @param pipelineStage - 
 * @param queryPool - 
 * @param query - 
 */
 private static native void vkCmdWriteTimestamp0(
             java.nio.ByteBuffer   commandBuffer,
             int   pipelineStage,
             java.nio.ByteBuffer   queryPool,
             int  query);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     vkCmdWriteTimestamp(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkPipelineStageFlagBits) pipelineStage,
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) query);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 132
 * <h2>Prototype</h2><pre>
 *  void  vkCmdCopyQueryPoolResults(
 *     VkCommandBuffer                             commandBuffer,
 *     VkQueryPool                                 queryPool,
 *     uint32_t                                    firstQuery,
 *     uint32_t                                    queryCount,
 *     VkBuffer                                    dstBuffer,
 *     VkDeviceSize                                dstOffset,
 *     VkDeviceSize                                stride,
 *     VkQueryResultFlags                          flags);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param stride - 
 * @param flags - 
 */
public void vkCmdCopyQueryPoolResults(
             VkCommandBuffer commandBuffer,
             VkQueryPool queryPool,
             int firstQuery,
             int queryCount,
             VkBuffer dstBuffer,
             long dstOffset,
             long stride,
             int flags){
     vkCmdCopyQueryPoolResults0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (queryPool==null ? null : queryPool.getHandle()) /* ByteBuffer */ ,
             firstQuery ,
             queryCount ,
             (dstBuffer==null ? null : dstBuffer.getHandle()) /* ByteBuffer */ ,
             dstOffset ,
             stride ,
             flags  );

} 

/**
 *  Native interface for Vulkan method #132
 *  vkCmdCopyQueryPoolResults 
 * 
 * @param commandBuffer - 
 * @param queryPool - 
 * @param firstQuery - 
 * @param queryCount - 
 * @param dstBuffer - 
 * @param dstOffset - 
 * @param stride - 
 * @param flags - 
 */
 private static native void vkCmdCopyQueryPoolResults0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   queryPool,
             int  firstQuery,
             int  queryCount,
             java.nio.ByteBuffer   dstBuffer,
             long  dstOffset,
             long  stride,
             int  flags);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkQueryPool* ptr_queryPool = (VkQueryPool*) queryPool;
     VkBuffer* ptr_dstBuffer = (VkBuffer*) dstBuffer;
     vkCmdCopyQueryPoolResults(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkQueryPool) (*ptr_queryPool),
                     (uint32_t) firstQuery,
                     (uint32_t) queryCount,
                     (VkBuffer) (*ptr_dstBuffer),
                     (VkDeviceSize) dstOffset,
                     (VkDeviceSize) stride,
                     (VkQueryResultFlags) flags);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 133
 * <h2>Prototype</h2><pre>
 *  void  vkCmdPushConstants(
 *     VkCommandBuffer                             commandBuffer,
 *     VkPipelineLayout                            layout,
 *     VkShaderStageFlags                          stageFlags,
 *     uint32_t                                    offset,
 *     uint32_t                                    size,
 *     const void*                                 pValues);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param layout - 
 * @param stageFlags - 
 * @param offset - 
 * @param size - 
 * @param pValues - 
 */
public void vkCmdPushConstants(
             VkCommandBuffer commandBuffer,
             VkPipelineLayout layout,
             int stageFlags,
             int offset,
             int size,
             java.nio.Buffer pValues){
     vkCmdPushConstants0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (layout==null ? null : layout.getHandle()) /* ByteBuffer */ ,
             stageFlags ,
             offset ,
             size ,
             pValues  );

} 

/**
 *  Native interface for Vulkan method #133
 *  vkCmdPushConstants 
 * 
 * @param commandBuffer - 
 * @param layout - 
 * @param stageFlags - 
 * @param offset - 
 * @param size - 
 * @param pValues - 
 */
 private static native void vkCmdPushConstants0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   layout,
             int  stageFlags,
             int  offset,
             int  size,
             java.nio.Buffer  pValues);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     VkPipelineLayout* ptr_layout = (VkPipelineLayout*) layout;
     vkCmdPushConstants(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkPipelineLayout) (*ptr_layout),
                     (VkShaderStageFlags) stageFlags,
                     (uint32_t) offset,
                     (uint32_t) size,
                     (const void*) pValues);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 134
 * <h2>Prototype</h2><pre>
 *  void  vkCmdBeginRenderPass(
 *     VkCommandBuffer                             commandBuffer,
 *     const VkRenderPassBeginInfo*                pRenderPassBegin,
 *     VkSubpassContents                           contents);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param pRenderPassBegin - 
 * @param contents - 
 */
public void vkCmdBeginRenderPass(
             VkCommandBuffer commandBuffer,
              VkRenderPassBeginInfo  pRenderPassBegin,
             VkSubpassContents contents){
     vkCmdBeginRenderPass0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             (pRenderPassBegin==null ? null : pRenderPassBegin.getPointerStruct()) /* ByteBuffer */ ,
             contents.getValue() /* enum */ );

} 

/**
 *  Native interface for Vulkan method #134
 *  vkCmdBeginRenderPass 
 * 
 * @param commandBuffer - 
 * @param pRenderPassBegin - 
 * @param contents - 
 */
 private static native void vkCmdBeginRenderPass0(
             java.nio.ByteBuffer   commandBuffer,
             java.nio.ByteBuffer   pRenderPassBegin,
             int   contents);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdBeginRenderPass(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (const VkRenderPassBeginInfo*) pRenderPassBegin,
                     (VkSubpassContents) contents);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 135
 * <h2>Prototype</h2><pre>
 *  void  vkCmdNextSubpass(
 *     VkCommandBuffer                             commandBuffer,
 *     VkSubpassContents                           contents);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param contents - 
 */
public void vkCmdNextSubpass(
             VkCommandBuffer commandBuffer,
             VkSubpassContents contents){
     vkCmdNextSubpass0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             contents.getValue() /* enum */ );

} 

/**
 *  Native interface for Vulkan method #135
 *  vkCmdNextSubpass 
 * 
 * @param commandBuffer - 
 * @param contents - 
 */
 private static native void vkCmdNextSubpass0(
             java.nio.ByteBuffer   commandBuffer,
             int   contents);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdNextSubpass(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (VkSubpassContents) contents);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 136
 * <h2>Prototype</h2><pre>
 *  void  vkCmdEndRenderPass(
 *     VkCommandBuffer                             commandBuffer);
 * </pre>
 * 
 * @param commandBuffer - 
 */
public void vkCmdEndRenderPass(
             VkCommandBuffer commandBuffer){
     vkCmdEndRenderPass0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #136
 *  vkCmdEndRenderPass 
 * 
 * @param commandBuffer - 
 */
 private static native void vkCmdEndRenderPass0(
             java.nio.ByteBuffer   commandBuffer);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdEndRenderPass(
                     (VkCommandBuffer) (*ptr_commandBuffer));

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 137
 * <h2>Prototype</h2><pre>
 *  void  vkCmdExecuteCommands(
 *     VkCommandBuffer                             commandBuffer,
 *     uint32_t                                    commandBufferCount,
 *     const VkCommandBuffer*                      pCommandBuffers);
 * </pre>
 * 
 * @param commandBuffer - 
 * @param commandBufferCount - 
 * @param pCommandBuffers - 
 */
public void vkCmdExecuteCommands(
             VkCommandBuffer commandBuffer,
             int commandBufferCount,
              VkCommandBuffer  pCommandBuffers){
     vkCmdExecuteCommands0(
             (commandBuffer==null ? null : commandBuffer.getHandle()) /* ByteBuffer */ ,
             commandBufferCount ,
             (pCommandBuffers==null ? null : pCommandBuffers.getHandle()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #137
 *  vkCmdExecuteCommands 
 * 
 * @param commandBuffer - 
 * @param commandBufferCount - 
 * @param pCommandBuffers - 
 */
 private static native void vkCmdExecuteCommands0(
             java.nio.ByteBuffer   commandBuffer,
             int  commandBufferCount,
             java.nio.ByteBuffer   pCommandBuffers);/* 
     VkCommandBuffer* ptr_commandBuffer = (VkCommandBuffer*) commandBuffer;
     vkCmdExecuteCommands(
                     (VkCommandBuffer) (*ptr_commandBuffer),
                     (uint32_t) commandBufferCount,
                     (const VkCommandBuffer*) pCommandBuffers);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 138
 * <h2>Prototype</h2><pre>
 *  void  vkDestroySurfaceKHR(
 *     VkInstance                                  instance,
 *     VkSurfaceKHR                                surface,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param instance - 
 * @param surface - 
 * @param pAllocator - 
 */
public void vkDestroySurfaceKHR(
             VkInstance instance,
             VkSurfaceKHR surface,
              VkAllocationCallbacks  pAllocator){
     vkDestroySurfaceKHR0(
             (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
             (surface==null ? null : surface.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #138
 *  vkDestroySurfaceKHR 
 * 
 * @param instance - 
 * @param surface - 
 * @param pAllocator - 
 */
 private static native void vkDestroySurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   surface,
             java.nio.ByteBuffer   pAllocator);/* 
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkSurfaceKHR* ptr_surface = (VkSurfaceKHR*) surface;
     vkDestroySurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (VkSurfaceKHR) (*ptr_surface),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 139
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceSurfaceSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex,
 *     VkSurfaceKHR                                surface,
 *     VkBool32*                                   pSupported);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param surface - 
 * @param pSupported - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceSurfaceSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex,
             VkSurfaceKHR surface,
             boolean[] pSupported){
     int  _val = vkGetPhysicalDeviceSurfaceSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex ,
                     (surface==null ? null : surface.getHandle()) /* ByteBuffer */ ,
                     pSupported  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #139
 *  vkGetPhysicalDeviceSurfaceSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param surface - 
 * @param pSupported - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceSurfaceSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex,
             java.nio.ByteBuffer   surface,
             boolean[]  pSupported);/* 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkSurfaceKHR* ptr_surface = (VkSurfaceKHR*) surface;
     VkResult res = vkGetPhysicalDeviceSurfaceSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex,
                     (VkSurfaceKHR) (*ptr_surface),
                     (VkBool32*) pSupported);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 140
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceSurfaceCapabilitiesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkSurfaceKHR                                surface,
 *     VkSurfaceCapabilitiesKHR*                   pSurfaceCapabilities);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pSurfaceCapabilities - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceSurfaceCapabilitiesKHR(
             VkPhysicalDevice physicalDevice,
             VkSurfaceKHR surface,
              VkSurfaceCapabilitiesKHR  pSurfaceCapabilities){
     int  _val = vkGetPhysicalDeviceSurfaceCapabilitiesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (surface==null ? null : surface.getHandle()) /* ByteBuffer */ ,
                     (pSurfaceCapabilities==null ? null : pSurfaceCapabilities.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #140
 *  vkGetPhysicalDeviceSurfaceCapabilitiesKHR 
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pSurfaceCapabilities - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceSurfaceCapabilitiesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   surface,
             java.nio.ByteBuffer   pSurfaceCapabilities);/* 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkSurfaceKHR* ptr_surface = (VkSurfaceKHR*) surface;
     VkResult res = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkSurfaceKHR) (*ptr_surface),
                     (VkSurfaceCapabilitiesKHR*) pSurfaceCapabilities);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 141
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceSurfaceFormatsKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkSurfaceKHR                                surface,
 *     uint32_t*                                   pSurfaceFormatCount,
 *     VkSurfaceFormatKHR*                         pSurfaceFormats);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pSurfaceFormatCount - 
 * @param pSurfaceFormats - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceSurfaceFormatsKHR(
             VkPhysicalDevice physicalDevice,
             VkSurfaceKHR surface,
             int[] pSurfaceFormatCount,
              VkSurfaceFormatKHR  pSurfaceFormats){
     int  _val = vkGetPhysicalDeviceSurfaceFormatsKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (surface==null ? null : surface.getHandle()) /* ByteBuffer */ ,
                     pSurfaceFormatCount ,
                     (pSurfaceFormats==null ? null : pSurfaceFormats.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #141
 *  vkGetPhysicalDeviceSurfaceFormatsKHR 
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pSurfaceFormatCount - 
 * @param pSurfaceFormats - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceSurfaceFormatsKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   surface,
             int[]  pSurfaceFormatCount,
             java.nio.ByteBuffer   pSurfaceFormats);/* 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkSurfaceKHR* ptr_surface = (VkSurfaceKHR*) surface;
     VkResult res = vkGetPhysicalDeviceSurfaceFormatsKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkSurfaceKHR) (*ptr_surface),
                     (uint32_t*) pSurfaceFormatCount,
                     (VkSurfaceFormatKHR*) pSurfaceFormats);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 142
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceSurfacePresentModesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkSurfaceKHR                                surface,
 *     uint32_t*                                   pPresentModeCount,
 *     VkPresentModeKHR*                           pPresentModes);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pPresentModeCount - 
 * @param pPresentModes - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceSurfacePresentModesKHR(
             VkPhysicalDevice physicalDevice,
             VkSurfaceKHR surface,
             int[] pPresentModeCount,
             VkPresentModeKHR[]  pPresentModes){
     int len = Math.min(pPresentModeCount[0],pPresentModes.length);
     
     int[] enumValues = new int[len];
     int  _val = vkGetPhysicalDeviceSurfacePresentModesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (surface==null ? null : surface.getHandle()) /* ByteBuffer */ ,
                     pPresentModeCount ,
                     enumValues /* enum */ );
     
    for (int i = 0; i < enumValues.length; i++) {
          pPresentModes[i] = VkPresentModeKHR.fromValue(enumValues[i]);
    }
    // remove dirty
    for(int i = enumValues.length; i < pPresentModes.length; i++){
        pPresentModes[i] = null;
    }
    
    return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #142
 *  vkGetPhysicalDeviceSurfacePresentModesKHR 
 * 
 * @param physicalDevice - 
 * @param surface - 
 * @param pPresentModeCount - 
 * @param pPresentModes - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceSurfacePresentModesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   surface,
             int[]  pPresentModeCount,
             int[]   pPresentModes);/* 
             
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkSurfaceKHR* ptr_surface = (VkSurfaceKHR*) surface;
     VkResult res = vkGetPhysicalDeviceSurfacePresentModesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkSurfaceKHR) (*ptr_surface),
                     (uint32_t*) pPresentModeCount,
                     (VkPresentModeKHR*) pPresentModes);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 143
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateSwapchainKHR(
 *     VkDevice                                    device,
 *     const VkSwapchainCreateInfoKHR*             pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSwapchainKHR*                             pSwapchain);
 * </pre>
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSwapchain - 
 * 
 * @return VkResult
 */
public VkResult vkCreateSwapchainKHR(
             VkDevice device,
              VkSwapchainCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSwapchainKHR  pSwapchain){
     int  _val = vkCreateSwapchainKHR0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSwapchain==null ? null : pSwapchain.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #143
 *  vkCreateSwapchainKHR 
 * 
 * @param device - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSwapchain - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateSwapchainKHR0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSwapchain);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateSwapchainKHR(
                     (VkDevice) (*ptr_device),
                     (const VkSwapchainCreateInfoKHR*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSwapchainKHR*) pSwapchain);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 144
 * <h2>Prototype</h2><pre>
 *  void  vkDestroySwapchainKHR(
 *     VkDevice                                    device,
 *     VkSwapchainKHR                              swapchain,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param device - 
 * @param swapchain - 
 * @param pAllocator - 
 */
public void vkDestroySwapchainKHR(
             VkDevice device,
             VkSwapchainKHR swapchain,
              VkAllocationCallbacks  pAllocator){
     vkDestroySwapchainKHR0(
             (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
             (swapchain==null ? null : swapchain.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #144
 *  vkDestroySwapchainKHR 
 * 
 * @param device - 
 * @param swapchain - 
 * @param pAllocator - 
 */
 private static native void vkDestroySwapchainKHR0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   swapchain,
             java.nio.ByteBuffer   pAllocator);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkSwapchainKHR* ptr_swapchain = (VkSwapchainKHR*) swapchain;
     vkDestroySwapchainKHR(
                     (VkDevice) (*ptr_device),
                     (VkSwapchainKHR) (*ptr_swapchain),
                     (const VkAllocationCallbacks*) pAllocator);

*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 145
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetSwapchainImagesKHR(
 *     VkDevice                                    device,
 *     VkSwapchainKHR                              swapchain,
 *     uint32_t*                                   pSwapchainImageCount,
 *     VkImage*                                    pSwapchainImages);
 * </pre>
 * 
 * @param device - 
 * @param swapchain - 
 * @param pSwapchainImageCount - 
 * @param pSwapchainImages - 
 * 
 * @return VkResult
 */
public VkResult vkGetSwapchainImagesKHR(
             VkDevice device,
             VkSwapchainKHR swapchain,
             int[] pSwapchainImageCount,
              VkImage  pSwapchainImages){
     int  _val = vkGetSwapchainImagesKHR0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (swapchain==null ? null : swapchain.getHandle()) /* ByteBuffer */ ,
                     pSwapchainImageCount ,
                     (pSwapchainImages==null ? null : pSwapchainImages.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #145
 *  vkGetSwapchainImagesKHR 
 * 
 * @param device - 
 * @param swapchain - 
 * @param pSwapchainImageCount - 
 * @param pSwapchainImages - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetSwapchainImagesKHR0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   swapchain,
             int[]  pSwapchainImageCount,
             java.nio.ByteBuffer   pSwapchainImages);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkSwapchainKHR* ptr_swapchain = (VkSwapchainKHR*) swapchain;
     VkResult res = vkGetSwapchainImagesKHR(
                     (VkDevice) (*ptr_device),
                     (VkSwapchainKHR) (*ptr_swapchain),
                     (uint32_t*) pSwapchainImageCount,
                     (VkImage*) pSwapchainImages);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 146
 * <h2>Prototype</h2><pre>
 *  VkResult  vkAcquireNextImageKHR(
 *     VkDevice                                    device,
 *     VkSwapchainKHR                              swapchain,
 *     uint64_t                                    timeout,
 *     VkSemaphore                                 semaphore,
 *     VkFence                                     fence,
 *     uint32_t*                                   pImageIndex);
 * </pre>
 * 
 * @param device - 
 * @param swapchain - 
 * @param timeout - 
 * @param semaphore - 
 * @param fence - 
 * @param pImageIndex - 
 * 
 * @return VkResult
 */
public VkResult vkAcquireNextImageKHR(
             VkDevice device,
             VkSwapchainKHR swapchain,
             long timeout,
             VkSemaphore semaphore,
             VkFence fence,
             int[] pImageIndex){
     int  _val = vkAcquireNextImageKHR0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     (swapchain==null ? null : swapchain.getHandle()) /* ByteBuffer */ ,
                     timeout ,
                     (semaphore==null ? null : semaphore.getHandle()) /* ByteBuffer */ ,
                     (fence==null ? null : fence.getHandle()) /* ByteBuffer */ ,
                     pImageIndex  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #146
 *  vkAcquireNextImageKHR 
 * 
 * @param device - 
 * @param swapchain - 
 * @param timeout - 
 * @param semaphore - 
 * @param fence - 
 * @param pImageIndex - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkAcquireNextImageKHR0(
             java.nio.ByteBuffer   device,
             java.nio.ByteBuffer   swapchain,
             long  timeout,
             java.nio.ByteBuffer   semaphore,
             java.nio.ByteBuffer   fence,
             int[]  pImageIndex);/* 
     VkDevice* ptr_device = (VkDevice*) device;
     VkSwapchainKHR* ptr_swapchain = (VkSwapchainKHR*) swapchain;
     VkSemaphore* ptr_semaphore = (VkSemaphore*) semaphore;
     VkFence* ptr_fence = (VkFence*) fence;
     VkResult res = vkAcquireNextImageKHR(
                     (VkDevice) (*ptr_device),
                     (VkSwapchainKHR) (*ptr_swapchain),
                     (uint64_t) timeout,
                     (VkSemaphore) (*ptr_semaphore),
                     (VkFence) (*ptr_fence),
                     (uint32_t*) pImageIndex);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 147
 * <h2>Prototype</h2><pre>
 *  VkResult  vkQueuePresentKHR(
 *     VkQueue                                     queue,
 *     const VkPresentInfoKHR*                     pPresentInfo);
 * </pre>
 * 
 * @param queue - 
 * @param pPresentInfo - 
 * 
 * @return VkResult
 */
public VkResult vkQueuePresentKHR(
             VkQueue queue,
              VkPresentInfoKHR  pPresentInfo){
     int  _val = vkQueuePresentKHR0(
                     (queue==null ? null : queue.getHandle()) /* ByteBuffer */ ,
                     (pPresentInfo==null ? null : pPresentInfo.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #147
 *  vkQueuePresentKHR 
 * 
 * @param queue - 
 * @param pPresentInfo - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkQueuePresentKHR0(
             java.nio.ByteBuffer   queue,
             java.nio.ByteBuffer   pPresentInfo);/* 
     VkQueue* ptr_queue = (VkQueue*) queue;
     VkResult res = vkQueuePresentKHR(
                     (VkQueue) (*ptr_queue),
                     (const VkPresentInfoKHR*) pPresentInfo);
      return (jint) res;
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 148
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceDisplayPropertiesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t*                                   pPropertyCount,
 *     VkDisplayPropertiesKHR*                     pProperties);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceDisplayPropertiesKHR(
             VkPhysicalDevice physicalDevice,
             int[] pPropertyCount,
              VkDisplayPropertiesKHR  pProperties){
     int  _val = vkGetPhysicalDeviceDisplayPropertiesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     pPropertyCount ,
                     (pProperties==null ? null : pProperties.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #148
 *  vkGetPhysicalDeviceDisplayPropertiesKHR 
 * 
 * @param physicalDevice - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceDisplayPropertiesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int[]  pPropertyCount,
             java.nio.ByteBuffer   pProperties);/* 
    #ifdef BOR_LOADER         
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkResult res = vkGetPhysicalDeviceDisplayPropertiesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t*) pPropertyCount,
                     (VkDisplayPropertiesKHR*) pProperties);
      return (jint) res;
    #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
    #endif    
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 149
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t*                                   pPropertyCount,
 *     VkDisplayPlanePropertiesKHR*                pProperties);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult
 */
public VkResult vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
             VkPhysicalDevice physicalDevice,
             int[] pPropertyCount,
              VkDisplayPlanePropertiesKHR  pProperties){
     int  _val = vkGetPhysicalDeviceDisplayPlanePropertiesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     pPropertyCount ,
                     (pProperties==null ? null : pProperties.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #149
 *  vkGetPhysicalDeviceDisplayPlanePropertiesKHR 
 * 
 * @param physicalDevice - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetPhysicalDeviceDisplayPlanePropertiesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int[]  pPropertyCount,
             java.nio.ByteBuffer   pProperties);/* 
  #ifdef BOR_LOADER 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkResult res = vkGetPhysicalDeviceDisplayPlanePropertiesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t*) pPropertyCount,
                     (VkDisplayPlanePropertiesKHR*) pProperties);
      return (jint) res;
  #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
  #endif     
      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 150
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetDisplayPlaneSupportedDisplaysKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    planeIndex,
 *     uint32_t*                                   pDisplayCount,
 *     VkDisplayKHR*                               pDisplays);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param planeIndex - 
 * @param pDisplayCount - 
 * @param pDisplays - 
 * 
 * @return VkResult
 */
public VkResult vkGetDisplayPlaneSupportedDisplaysKHR(
             VkPhysicalDevice physicalDevice,
             int planeIndex,
             int[] pDisplayCount,
              VkDisplayKHR  pDisplays){
     int  _val = vkGetDisplayPlaneSupportedDisplaysKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     planeIndex ,
                     pDisplayCount ,
                     (pDisplays==null ? null : pDisplays.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #150
 *  vkGetDisplayPlaneSupportedDisplaysKHR 
 * 
 * @param physicalDevice - 
 * @param planeIndex - 
 * @param pDisplayCount - 
 * @param pDisplays - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetDisplayPlaneSupportedDisplaysKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  planeIndex,
             int[]  pDisplayCount,
             java.nio.ByteBuffer   pDisplays);/* 
#ifdef BOR_LOADER            
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkResult res = vkGetDisplayPlaneSupportedDisplaysKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) planeIndex,
                     (uint32_t*) pDisplayCount,
                     (VkDisplayKHR*) pDisplays);
      return (jint) res;
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 151
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetDisplayModePropertiesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkDisplayKHR                                display,
 *     uint32_t*                                   pPropertyCount,
 *     VkDisplayModePropertiesKHR*                 pProperties);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param display - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult
 */
public VkResult vkGetDisplayModePropertiesKHR(
             VkPhysicalDevice physicalDevice,
             VkDisplayKHR display,
             int[] pPropertyCount,
              VkDisplayModePropertiesKHR  pProperties){
     int  _val = vkGetDisplayModePropertiesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (display==null ? null : display.getHandle()) /* ByteBuffer */ ,
                     pPropertyCount ,
                     (pProperties==null ? null : pProperties.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #151
 *  vkGetDisplayModePropertiesKHR 
 * 
 * @param physicalDevice - 
 * @param display - 
 * @param pPropertyCount - 
 * @param pProperties - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetDisplayModePropertiesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   display,
             int[]  pPropertyCount,
             java.nio.ByteBuffer   pProperties);/* 
 #ifdef BOR_LOADER 
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkDisplayKHR* ptr_display = (VkDisplayKHR*) display;
     VkResult res = vkGetDisplayModePropertiesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkDisplayKHR) (*ptr_display),
                     (uint32_t*) pPropertyCount,
                     (VkDisplayModePropertiesKHR*) pProperties);
      return (jint) res;
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 152
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateDisplayModeKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkDisplayKHR                                display,
 *     const VkDisplayModeCreateInfoKHR*           pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkDisplayModeKHR*                           pMode);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param display - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pMode - 
 * 
 * @return VkResult
 */
public VkResult vkCreateDisplayModeKHR(
             VkPhysicalDevice physicalDevice,
             VkDisplayKHR display,
              VkDisplayModeCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkDisplayModeKHR  pMode){
     int  _val = vkCreateDisplayModeKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (display==null ? null : display.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pMode==null ? null : pMode.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #152
 *  vkCreateDisplayModeKHR 
 * 
 * @param physicalDevice - 
 * @param display - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pMode - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateDisplayModeKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   display,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pMode);/* 
 #ifdef BOR_LOADER            
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkDisplayKHR* ptr_display = (VkDisplayKHR*) display;
     VkResult res = vkCreateDisplayModeKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkDisplayKHR) (*ptr_display),
                     (const VkDisplayModeCreateInfoKHR*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkDisplayModeKHR*) pMode);
      return (jint) res;
      
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif        
      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 153
 * <h2>Prototype</h2><pre>
 *  VkResult  vkGetDisplayPlaneCapabilitiesKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     VkDisplayModeKHR                            mode,
 *     uint32_t                                    planeIndex,
 *     VkDisplayPlaneCapabilitiesKHR*              pCapabilities);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param mode - 
 * @param planeIndex - 
 * @param pCapabilities - 
 * 
 * @return VkResult
 */
public VkResult vkGetDisplayPlaneCapabilitiesKHR(
             VkPhysicalDevice physicalDevice,
             VkDisplayModeKHR mode,
             int planeIndex,
              VkDisplayPlaneCapabilitiesKHR  pCapabilities){
     int  _val = vkGetDisplayPlaneCapabilitiesKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     (mode==null ? null : mode.getHandle()) /* ByteBuffer */ ,
                     planeIndex ,
                     (pCapabilities==null ? null : pCapabilities.getPointerStruct()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #153
 *  vkGetDisplayPlaneCapabilitiesKHR 
 * 
 * @param physicalDevice - 
 * @param mode - 
 * @param planeIndex - 
 * @param pCapabilities - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkGetDisplayPlaneCapabilitiesKHR0(
             java.nio.ByteBuffer   physicalDevice,
             java.nio.ByteBuffer   mode,
             int  planeIndex,
             java.nio.ByteBuffer   pCapabilities);/* 
   #ifdef BOR_LOADER            
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VkDisplayModeKHR* ptr_mode = (VkDisplayModeKHR*) mode;
     VkResult res = vkGetDisplayPlaneCapabilitiesKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (VkDisplayModeKHR) (*ptr_mode),
                     (uint32_t) planeIndex,
                     (VkDisplayPlaneCapabilitiesKHR*) pCapabilities);
      return (jint) res;
    
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif    
      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 154
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateDisplayPlaneSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkDisplaySurfaceCreateInfoKHR*        pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateDisplayPlaneSurfaceKHR(
             VkInstance instance,
              VkDisplaySurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateDisplayPlaneSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #154
 *  vkCreateDisplayPlaneSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateDisplayPlaneSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
   #ifdef BOR_LOADER            
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateDisplayPlaneSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (const VkDisplaySurfaceCreateInfoKHR*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif    
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 155
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateSharedSwapchainsKHR(
 *     VkDevice                                    device,
 *     uint32_t                                    swapchainCount,
 *     const VkSwapchainCreateInfoKHR*             pCreateInfos,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSwapchainKHR*                             pSwapchains);
 * </pre>
 * 
 * @param device - 
 * @param swapchainCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pSwapchains - 
 * 
 * @return VkResult
 */
public VkResult vkCreateSharedSwapchainsKHR(
             VkDevice device,
             int swapchainCount,
              VkSwapchainCreateInfoKHR  pCreateInfos,
              VkAllocationCallbacks  pAllocator,
              VkSwapchainKHR  pSwapchains){
     int  _val = vkCreateSharedSwapchainsKHR0(
                     (device==null ? null : device.getHandle()) /* ByteBuffer */ ,
                     swapchainCount ,
                     (pCreateInfos==null ? null : pCreateInfos.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSwapchains==null ? null : pSwapchains.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #155
 *  vkCreateSharedSwapchainsKHR 
 * 
 * @param device - 
 * @param swapchainCount - 
 * @param pCreateInfos - 
 * @param pAllocator - 
 * @param pSwapchains - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateSharedSwapchainsKHR0(
             java.nio.ByteBuffer   device,
             int  swapchainCount,
             java.nio.ByteBuffer   pCreateInfos,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSwapchains);/* 
 #ifdef BOR_LOADER
     VkDevice* ptr_device = (VkDevice*) device;
     VkResult res = vkCreateSharedSwapchainsKHR(
                     (VkDevice) (*ptr_device),
                     (uint32_t) swapchainCount,
                     (const VkSwapchainCreateInfoKHR*) pCreateInfos,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSwapchainKHR*) pSwapchains);
      return (jint) res;
  #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 156
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateXlibSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkXlibSurfaceCreateInfoKHR*           pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateXlibSurfaceKHR(
             VkInstance instance,
              VkXlibSurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateXlibSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #156
 *  vkCreateXlibSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateXlibSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
             
    #ifdef VK_USE_PLATFORM_XLIB_KHR         
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateXlibSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (VkXlibSurfaceCreateInfoKHR*) pCreateInfo,
                     (VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;
     #else
      return (jint) VkResult::VK_ERROR_INCOMPATIBLE_DRIVER;
     #endif   
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 157
 * <h2>Prototype</h2><pre>
 *  VkBool32  vkGetPhysicalDeviceXlibPresentationSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex,
 *     Display*                                    dpy,
 *     VisualID                                    visualID);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param dpy - 
 * @param visualID - 
 * 
 * @return boolean
 */
public boolean vkGetPhysicalDeviceXlibPresentationSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex,
             XlibDisplay dpy,
             XlibVisualID visualID){
     boolean _val = vkGetPhysicalDeviceXlibPresentationSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex ,
                     (dpy==null ? null : dpy.getHandle()) /* ByteBuffer */ ,
                     (visualID==null ? null : visualID.getHandle()) /* ByteBuffer */  );
      return _val;
} 

/**
 *  Native interface for Vulkan method #157
 *  vkGetPhysicalDeviceXlibPresentationSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param dpy - 
 * @param visualID - 
 * 
 * @return boolean as boolean 
 */
 private static native boolean vkGetPhysicalDeviceXlibPresentationSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex,
             java.nio.ByteBuffer   dpy,
             java.nio.ByteBuffer   visualID);/* 
   #ifdef VK_USE_PLATFORM_XCB_KHR
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     VisualID* ptr_visualID = (VisualID*) visualID;
     boolean res = vkGetPhysicalDeviceXlibPresentationSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex,
                     (Display*) dpy,
                     (VisualID) (*ptr_visualID));
      return (jboolean) res;
   #else
    return (jboolean)JNI_FALSE;
   #endif    
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 158
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateXcbSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkXcbSurfaceCreateInfoKHR*            pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateXcbSurfaceKHR(
             VkInstance instance,
              VkXcbSurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateXcbSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #158
 *  vkCreateXcbSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateXcbSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
   #ifdef VK_USE_PLATFORM_XCB_KHR          
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateXcbSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (VkXcbSurfaceCreateInfoKHR*) pCreateInfo,
                     (VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;
   #else
    return (jint) VkResult::VK_ERROR_INCOMPATIBLE_DRIVER;
   #endif 
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 159
 * <h2>Prototype</h2><pre>
 *  VkBool32  vkGetPhysicalDeviceXcbPresentationSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex,
 *     xcb_connection_t*                           connection,
 *     xcb_visualid_t                              visual_id);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param connection - 
 * @param visual_id - 
 * 
 * @return boolean
 */
public boolean vkGetPhysicalDeviceXcbPresentationSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex,
             XCBconnection connection,
             XCBVisualID visual_id){
     boolean _val = vkGetPhysicalDeviceXcbPresentationSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex ,
                     (connection==null ? null : connection.getHandle()) /* ByteBuffer */ ,
                     visual_id  );
      return _val;
} 

/**
 *  Native interface for Vulkan method #159
 *  vkGetPhysicalDeviceXcbPresentationSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param connection - 
 * @param visual_id - 
 * 
 * @return boolean as boolean 
 */
 private static native boolean vkGetPhysicalDeviceXcbPresentationSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex,
             java.nio.ByteBuffer   connection,
             XCBVisualID  visual_id);/* 
   #ifdef VK_USE_PLATFORM_XCB_KHR         
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     boolean res = vkGetPhysicalDeviceXcbPresentationSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex,
                     (xcb_connection_t*) connection,
                     (xcb_visualid_t) visual_id);
      return (jboolean) res;
    #else
     return JNI_FALSE;
    #endif   
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 160
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateWaylandSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkWaylandSurfaceCreateInfoKHR*        pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateWaylandSurfaceKHR(
             VkInstance instance,
              VkWaylandSurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateWaylandSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #160
 *  vkCreateWaylandSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateWaylandSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
  #ifdef VK_USE_PLATFORM_WAYLAND_KHR        
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateWaylandSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     ( VkWaylandSurfaceCreateInfoKHR*) pCreateInfo,
                     ( VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;  
#else
      return (jint) VkResult::VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;  
#endif       
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 161
 * <h2>Prototype</h2><pre>
 *  VkBool32  vkGetPhysicalDeviceWaylandPresentationSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex,
 *     struct wl_display*                          display);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param display - 
 * 
 * @return boolean
 */
public boolean vkGetPhysicalDeviceWaylandPresentationSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex,
             WlDisplay display){
     boolean _val = vkGetPhysicalDeviceWaylandPresentationSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex ,
                     (display==null ? null : display.getHandle()) /* ByteBuffer */  );
      return _val;
} 

/**
 *  Native interface for Vulkan method #161
 *  vkGetPhysicalDeviceWaylandPresentationSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param display - 
 * 
 * @return boolean as boolean 
 */
 private static native boolean vkGetPhysicalDeviceWaylandPresentationSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex,
             java.nio.ByteBuffer   display);/*
   #ifdef VK_USE_PLATFORM_WAYLAND_KHR           
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     bool res = vkGetPhysicalDeviceWaylandPresentationSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex,
                     (struct wl_display*) display);
      return (jboolean) res;
   #else
     return (jboolean) JNI_FALSE;   
   #endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 162
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateMirSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkMirSurfaceCreateInfoKHR*            pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateMirSurfaceKHR(
             VkInstance instance,
              VkMirSurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateMirSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #162
 *  vkCreateMirSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateMirSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
    #ifdef VK_USE_PLATFORM_MIR_KHR         
             
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateMirSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (const VkMirSurfaceCreateInfoKHR*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;
    #else
      return (jint) VkResult::VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;  
    #endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 163
 * <h2>Prototype</h2><pre>
 *  VkBool32  vkGetPhysicalDeviceMirPresentationSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex,
 *     MirConnection*                              connection);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param connection - 
 * 
 * @return boolean
 */
public boolean vkGetPhysicalDeviceMirPresentationSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex,
             MirConnection connection){
     boolean _val = vkGetPhysicalDeviceMirPresentationSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex ,
                     (connection==null ? null : connection.getHandle()) /* ByteBuffer */  );
      return _val;
} 

/**
 *  Native interface for Vulkan method #163
 *  vkGetPhysicalDeviceMirPresentationSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * @param connection - 
 * 
 * @return boolean as boolean 
 */
 private static native boolean vkGetPhysicalDeviceMirPresentationSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex,
             java.nio.ByteBuffer   connection);/* 
             
    #ifdef VK_USE_PLATFORM_MIR_KHR              
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     bool res = vkGetPhysicalDeviceMirPresentationSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex,
                     (MirConnection*) connection);
      return (jboolean) res;
     #else
      return (jboolean) JNI_FALSE; //VkResult::VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;  
     #endif 
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 164
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateAndroidSurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkAndroidSurfaceCreateInfoKHR*        pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateAndroidSurfaceKHR(
             VkInstance instance,
              VkAndroidSurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR[]  pSurface){
     int[] result = {0};
     ByteBuffer handle = vkCreateAndroidSurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     result);
     
     if(pSurface[0]==null){
         pSurface[0] = new VkHandle(handle);
     }else{
         pSurface[0].setPointer(handle);
     }
      return VkResult.fromValue(result[0]);
} 

/**
 *  Native interface for Vulkan method #164
 *  vkCreateAndroidSurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native java.nio.ByteBuffer vkCreateAndroidSurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             int[] result);/*
    #ifdef VK_USE_PLATFORM_ANDROID_KHR         
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkSurfaceKHR* pSurface = NULL;
     jobject buffer = NULL;
     VkResult res = vkCreateAndroidSurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     (const VkAndroidSurfaceCreateInfoKHR*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
                     
       if(pSurface){
         buffer = (jobject)(env->NewDirectByteBuffer((void*)pSurface, sizeof(void*)));
       }
      result[0] = (jint) res;               
      return buffer;
    #else
     result[0] = (jint)VkResult::VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;  
     return NULL;
    #endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 165
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateWin32SurfaceKHR(
 *     VkInstance                                  instance,
 *     const VkWin32SurfaceCreateInfoKHR*          pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkSurfaceKHR*                               pSurface);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult
 */
public VkResult vkCreateWin32SurfaceKHR(
             VkInstance instance,
              VkWin32SurfaceCreateInfoKHR  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkSurfaceKHR  pSurface){
     int  _val = vkCreateWin32SurfaceKHR0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pSurface==null ? null : pSurface.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #165
 *  vkCreateWin32SurfaceKHR 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pSurface - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateWin32SurfaceKHR0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pSurface);/* 
             
 #ifdef VK_USE_PLATFORM_WIN32_KHR            
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateWin32SurfaceKHR(
                     (VkInstance) (*ptr_instance),
                     ( VkWin32SurfaceCreateInfoKHR*) pCreateInfo,
                     ( VkAllocationCallbacks*) pAllocator,
                     (VkSurfaceKHR*) pSurface);
      return (jint) res;      
#else
      return (jint) VkResult::VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;  
#endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 166
 * <h2>Prototype</h2><pre>
 *  VkBool32  vkGetPhysicalDeviceWin32PresentationSupportKHR(
 *     VkPhysicalDevice                            physicalDevice,
 *     uint32_t                                    queueFamilyIndex);
 * </pre>
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * 
 * @return boolean
 */
public boolean vkGetPhysicalDeviceWin32PresentationSupportKHR(
             VkPhysicalDevice physicalDevice,
             int queueFamilyIndex){
     boolean _val = vkGetPhysicalDeviceWin32PresentationSupportKHR0(
                     (physicalDevice==null ? null : physicalDevice.getHandle()) /* ByteBuffer */ ,
                     queueFamilyIndex  );
      return _val;
} 

/**
 *  Native interface for Vulkan method #166
 *  vkGetPhysicalDeviceWin32PresentationSupportKHR 
 * 
 * @param physicalDevice - 
 * @param queueFamilyIndex - 
 * 
 * @return boolean as boolean 
 */
 private static native boolean vkGetPhysicalDeviceWin32PresentationSupportKHR0(
             java.nio.ByteBuffer   physicalDevice,
             int  queueFamilyIndex);/* 
   #ifdef VK_USE_PLATFORM_WIN32_KHR          
     VkPhysicalDevice* ptr_physicalDevice = (VkPhysicalDevice*) physicalDevice;
     bool res = vkGetPhysicalDeviceWin32PresentationSupportKHR(
                     (VkPhysicalDevice) (*ptr_physicalDevice),
                     (uint32_t) queueFamilyIndex);
      return (jboolean) res;
    #else
        return (jboolean) JNI_FALSE;
    #endif      
      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 167
 * <h2>Prototype</h2><pre>
 *  VkResult  vkCreateDebugReportCallbackEXT(
 *     VkInstance                                  instance,
 *     const VkDebugReportCallbackCreateInfoEXT*   pCreateInfo,
 *     const VkAllocationCallbacks*                pAllocator,
 *     VkDebugReportCallbackEXT*                   pCallback);
 * </pre>
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pCallback - 
 * 
 * @return VkResult
 */
public VkResult vkCreateDebugReportCallbackEXT(
             VkInstance instance,
              VkDebugReportCallbackCreateInfoEXT  pCreateInfo,
              VkAllocationCallbacks  pAllocator,
              VkDebugReportCallbackEXT  pCallback){
     int  _val = vkCreateDebugReportCallbackEXT0(
                     (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
                     (pCreateInfo==null ? null : pCreateInfo.getPointerStruct()) /* ByteBuffer */ ,
                     (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */ ,
                     (pCallback==null ? null : pCallback.getHandle()) /* ByteBuffer */  );
      return VkResult.fromValue(_val);
} 

/**
 *  Native interface for Vulkan method #167
 *  vkCreateDebugReportCallbackEXT 
 * 
 * @param instance - 
 * @param pCreateInfo - 
 * @param pAllocator - 
 * @param pCallback - 
 * 
 * @return VkResult as int  
 */
 private static native int  vkCreateDebugReportCallbackEXT0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   pCreateInfo,
             java.nio.ByteBuffer   pAllocator,
             java.nio.ByteBuffer   pCallback);/* 
  #ifdef BOR_LOADER            
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkResult res = vkCreateDebugReportCallbackEXT(
                     (VkInstance) (*ptr_instance),
                     (const VkDebugReportCallbackCreateInfoEXT*) pCreateInfo,
                     (const VkAllocationCallbacks*) pAllocator,
                     (VkDebugReportCallbackEXT*) pCallback);
      return (jint) res;
 #else
      return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif 
      
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 168
 * <h2>Prototype</h2><pre>
 *  void  vkDestroyDebugReportCallbackEXT(
 *     VkInstance                                  instance,
 *     VkDebugReportCallbackEXT                    callback,
 *     const VkAllocationCallbacks*                pAllocator);
 * </pre>
 * 
 * @param instance - 
 * @param callback - 
 * @param pAllocator - 
 */
public void vkDestroyDebugReportCallbackEXT(
             VkInstance instance,
             VkDebugReportCallbackEXT callback,
              VkAllocationCallbacks  pAllocator){
     vkDestroyDebugReportCallbackEXT0(
             (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
             (callback==null ? null : callback.getHandle()) /* ByteBuffer */ ,
             (pAllocator==null ? null : pAllocator.getPointerStruct()) /* ByteBuffer */  );

} 

/**
 *  Native interface for Vulkan method #168
 *  vkDestroyDebugReportCallbackEXT 
 * 
 * @param instance - 
 * @param callback - 
 * @param pAllocator - 
 */
 private static native void vkDestroyDebugReportCallbackEXT0(
             java.nio.ByteBuffer   instance,
             java.nio.ByteBuffer   callback,
             java.nio.ByteBuffer   pAllocator);/* 
#ifdef BOR_LOADER              
     VkInstance* ptr_instance = (VkInstance*) instance;
     VkDebugReportCallbackEXT* ptr_callback = (VkDebugReportCallbackEXT*) callback;
     vkDestroyDebugReportCallbackEXT(
                     (VkInstance) (*ptr_instance),
                     (VkDebugReportCallbackEXT) (*ptr_callback),
                     (const VkAllocationCallbacks*) pAllocator);
 #else
     // return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif  
*/ 


     /////////////////////////////////////

/**
 *  Vulkan procedure ID: 169
 * <h2>Prototype</h2><pre>
 *  void  vkDebugReportMessageEXT(
 *     VkInstance                                  instance,
 *     VkDebugReportFlagsEXT                       flags,
 *     VkDebugReportObjectTypeEXT                  objectType,
 *     uint64_t                                    object,
 *     size_t                                      location,
 *     int32_t                                     messageCode,
 *     const char*                                 pLayerPrefix,
 *     const char*                                 pMessage);
 * </pre>
 * 
 * @param instance - 
 * @param flags - 
 * @param objectType - 
 * @param object - 
 * @param location - 
 * @param messageCode - 
 * @param pLayerPrefix - 
 * @param pMessage - 
 */
public void vkDebugReportMessageEXT(
             VkInstance instance,
             int flags,
             VkDebugReportObjectTypeEXT objectType,
             long object,
             long location,
             int messageCode,
             String pLayerPrefix,
             String pMessage){
     vkDebugReportMessageEXT0(
             (instance==null ? null : instance.getHandle()) /* ByteBuffer */ ,
             flags ,
             objectType.getValue() /* enum */,
             object ,
             location ,
             messageCode ,
             pLayerPrefix ,
             pMessage  );

} 

/**
 *  Native interface for Vulkan method #169
 *  vkDebugReportMessageEXT 
 * 
 * @param instance - 
 * @param flags - 
 * @param objectType - 
 * @param object - 
 * @param location - 
 * @param messageCode - 
 * @param pLayerPrefix - 
 * @param pMessage - 
 */
 private static native void vkDebugReportMessageEXT0(
             java.nio.ByteBuffer   instance,
             int  flags,
             int   objectType,
             long  object,
             long  location,
             int  messageCode,
             String  pLayerPrefix,
             String  pMessage);/* 
             
  #ifdef BOR_LOADER             
     VkInstance* ptr_instance = (VkInstance*) instance;
     vkDebugReportMessageEXT(
                     (VkInstance) (*ptr_instance),
                     (VkDebugReportFlagsEXT) flags,
                     (VkDebugReportObjectTypeEXT) objectType,
                     (uint64_t) object,
                     (size_t) location,
                     (int32_t) messageCode,
                     (const char*) pLayerPrefix,
                     (const char*) pMessage);
 #else
    //  return (jint) VkResult::VK_ERROR_EXTENSION_NOT_PRESENT;
 #endif   
*/ 


     /////////////////////////////////////


    public Vk10() {       
    }

}
