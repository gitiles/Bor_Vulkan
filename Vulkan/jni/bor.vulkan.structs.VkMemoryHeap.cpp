#include <bor.vulkan.structs.VkMemoryHeap.h>

//@line:38

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkMemoryHeap_setSize0(JNIEnv* env, jclass clazz, jobject obj_ptr, jlong _size) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr):0);


//@line:202

		  VkMemoryHeap* vkObj = (VkMemoryHeap*)(ptr);
		  vkObj->size = (VkDeviceSize) (_size);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkMemoryHeap_getSize0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:211

		  VkMemoryHeap* vkObj = (VkMemoryHeap*)(ptr);
		  return (jlong) (vkObj->size);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkMemoryHeap_getSize0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr):0);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkMemoryHeap_getSize0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkMemoryHeap_setFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _flags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr):0);


//@line:220

		  VkMemoryHeap* vkObj = (VkMemoryHeap*)(ptr);
		  vkObj->flags = (VkMemoryHeapFlags) (_flags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkMemoryHeap_getFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:229

		  VkMemoryHeap* vkObj = (VkMemoryHeap*)(ptr);
		  return (jint) (vkObj->flags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkMemoryHeap_getFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr):0);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkMemoryHeap_getFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}
