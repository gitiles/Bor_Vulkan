/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class bor_vulkan_khr_WSI */

#ifndef _Included_bor_vulkan_khr_WSI
#define _Included_bor_vulkan_khr_WSI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    createWSI
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_createWSI
  (JNIEnv *, jclass, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    destroyWSI0
 * Signature: (Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_bor_vulkan_khr_WSI_destroyWSI0
  (JNIEnv *, jclass, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateAndroidSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_vkCreateAndroidSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateWin32SurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_vkCreateWin32SurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceWin32PresentationSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)Z
 */
JNIEXPORT jboolean JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceWin32PresentationSupportKHR0
  (JNIEnv *, jclass, jobject, jobject, jint);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceDisplayPropertiesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[II[I[I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceDisplayPropertiesKHR0
  (JNIEnv *, jclass, jobject, jobject, jintArray, jint, jintArray, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceDisplayPlanePropertiesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[IZ[I[I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceDisplayPlanePropertiesKHR0
  (JNIEnv *, jclass, jobject, jobject, jintArray, jboolean, jintArray, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetDisplayModePropertiesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[IZ[I[I)Ljava/nio/ByteBuffer;
 */
JNIEXPORT jobject JNICALL Java_bor_vulkan_khr_WSI_vkGetDisplayModePropertiesKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jintArray, jboolean, jintArray, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateDisplayModeKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateDisplayModeKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateDisplayPlaneSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateDisplayPlaneSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateSharedSwapchainsKHR0
 * Signature: (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateSharedSwapchainsKHR0
  (JNIEnv *, jclass, jobject, jint, jobject, jobject, jintArray, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateXlibSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateXlibSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceXlibPresentationSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Z
 */
JNIEXPORT jboolean JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceXlibPresentationSupportKHR0
  (JNIEnv *, jclass, jobject, jobject, jint, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateXcbSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateXcbSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceXcbPresentationSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;Lbor/vulkan/khr/XCBVisualID;)Z
 */
JNIEXPORT jboolean JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceXcbPresentationSupportKHR0
  (JNIEnv *, jclass, jobject, jint, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateWaylandSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateWaylandSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceWaylandPresentationSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)Z
 */
JNIEXPORT jboolean JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceWaylandPresentationSupportKHR0
  (JNIEnv *, jclass, jobject, jint, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateMirSurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateMirSurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceMirPresentationSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)Z
 */
JNIEXPORT jboolean JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceMirPresentationSupportKHR0
  (JNIEnv *, jclass, jobject, jint, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetDisplayPlaneCapabilitiesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetDisplayPlaneCapabilitiesKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jint, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetDisplayPlaneSupportedDisplaysKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I[I[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetDisplayPlaneSupportedDisplaysKHR0
  (JNIEnv *, jclass, jobject, jobject, jint, jintArray, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkDestroySurfaceKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_bor_vulkan_khr_WSI_vkDestroySurfaceKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceSurfaceSupportKHR0
 * Signature: (Ljava/nio/ByteBuffer;ILjava/nio/ByteBuffer;[Z)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceSurfaceSupportKHR0
  (JNIEnv *, jclass, jobject, jint, jobject, jbooleanArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceSurfaceCapabilitiesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceSurfaceCapabilitiesKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceSurfaceFormatsKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I[I[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceSurfaceFormatsKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jintArray, jintArray, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetPhysicalDeviceSurfacePresentModesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I[I)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetPhysicalDeviceSurfacePresentModesKHR0
  (JNIEnv *, jclass, jobject, jobject, jintArray, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkCreateSwapchainKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkCreateSwapchainKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkDestroySwapchainKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
 */
JNIEXPORT void JNICALL Java_bor_vulkan_khr_WSI_vkDestroySwapchainKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkGetSwapchainImagesKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I[Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkGetSwapchainImagesKHR0
  (JNIEnv *, jclass, jobject, jobject, jintArray, jobjectArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkAcquireNextImageKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;JLjava/nio/ByteBuffer;Ljava/nio/ByteBuffer;[I)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkAcquireNextImageKHR0
  (JNIEnv *, jclass, jobject, jobject, jlong, jobject, jobject, jintArray);

/*
 * Class:     bor_vulkan_khr_WSI
 * Method:    vkQueuePresentKHR0
 * Signature: (Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_bor_vulkan_khr_WSI_vkQueuePresentKHR0
  (JNIEnv *, jclass, jobject, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif