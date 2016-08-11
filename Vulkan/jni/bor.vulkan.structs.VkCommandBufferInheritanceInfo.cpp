#include <bor.vulkan.structs.VkCommandBufferInheritanceInfo.h>

//@line:45

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setSType0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _sType) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:398

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->sType = (VkStructureType) (_sType);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSType0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:408

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  return (VkStructureType) (vkObj->sType);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSType0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSType0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pNext) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pNext = (char*)(obj__pNext?env->GetDirectBufferAddress(obj__pNext) : NULL);


//@line:417

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for Buffer - referenced by ptr
		  vkObj->pNext = (const void*) (_pNext);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPNext0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:427

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  // generic get for Buffer 
		  return (jlong) reinterpret_cast<jlong>(&vkObj->pNext);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPNext0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setRenderPass0(JNIEnv* env, jclass clazz, jobject obj_ptr, jlong _renderPass) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:437

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->renderPass = (VkRenderPass) (_renderPass);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getRenderPass0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:447

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  // generic get for struct field of type  VkHandle or VkStruct 
		  return (jlong) reinterpret_cast<jlong>(&vkObj->renderPass);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getRenderPass0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getRenderPass0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setSubpass0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _subpass) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:457

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->subpass = (uint32_t) (_subpass);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSubpass0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:467

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  return (jint) (vkObj->subpass);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSubpass0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getSubpass0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setFramebuffer0(JNIEnv* env, jclass clazz, jobject obj_ptr, jlong _framebuffer) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:476

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->framebuffer = (VkFramebuffer) (_framebuffer);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getFramebuffer0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:486

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  // generic get for struct field of type  VkHandle or VkStruct 
		  return (jlong) reinterpret_cast<jlong>(&vkObj->framebuffer);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getFramebuffer0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getFramebuffer0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setOcclusionQueryEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr, jboolean _occlusionQueryEnable) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:496

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->occlusionQueryEnable = (VkBool32) (_occlusionQueryEnable);
	  

}

static inline jboolean wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getOcclusionQueryEnable0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:506

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  return (jboolean) (vkObj->occlusionQueryEnable);
	 
}

JNIEXPORT jboolean JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getOcclusionQueryEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jboolean JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getOcclusionQueryEnable0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setQueryFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _queryFlags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:515

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->queryFlags = (VkQueryControlFlags) (_queryFlags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getQueryFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:525

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  return (jint) (vkObj->queryFlags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getQueryFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getQueryFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_setPipelineStatistics0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _pipelineStatistics) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:534

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		 // code for simple past value 
		  vkObj->pipelineStatistics = (VkQueryPipelineStatisticFlags) (_pipelineStatistics);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPipelineStatistics0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:544

		  VkCommandBufferInheritanceInfo* vkObj = (VkCommandBufferInheritanceInfo*)(ptr);
		  return (jint) (vkObj->pipelineStatistics);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPipelineStatistics0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkCommandBufferInheritanceInfo_getPipelineStatistics0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}
