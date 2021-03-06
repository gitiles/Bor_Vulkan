#include <bor.vulkan.structs.VkPipelineLayoutCreateInfo.h>

//@line:44

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setSType0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _sType) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:385

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->sType = (VkStructureType) (_sType);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSType0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:395

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->sType);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSType0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSType0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pNext) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pNext = (char*)(obj__pNext?env->GetDirectBufferAddress(obj__pNext) : NULL);


//@line:405

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const void* p_pNext = ( void*) _pNext; 
		 vkObj->pNext = p_pNext; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPNext0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:416

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  // generic get for Buffer - field must be pointer! 
		  return (jlong) reinterpret_cast<jlong>(vkObj->pNext);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPNext0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _flags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:426

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->flags = (VkPipelineLayoutCreateFlags) (_flags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:436

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  return (jint) (vkObj->flags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setSetLayoutCount0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _setLayoutCount) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:445

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->setLayoutCount = (uint32_t) (_setLayoutCount);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSetLayoutCount0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:455

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  return (jint) (vkObj->setLayoutCount);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSetLayoutCount0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getSetLayoutCount0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setPSetLayouts0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pSetLayouts) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pSetLayouts = (char*)(obj__pSetLayouts?env->GetDirectBufferAddress(obj__pSetLayouts) : NULL);


//@line:464

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const VkDescriptorSetLayout* p_pSetLayouts = ( VkDescriptorSetLayout*) _pSetLayouts; 
		 vkObj->pSetLayouts = p_pSetLayouts; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPSetLayouts0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:475

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  // generic get for array of VkHandle and VkStruct 
		  return (jlong) reinterpret_cast<jlong>( vkObj->pSetLayouts );
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPSetLayouts0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPSetLayouts0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setPushConstantRangeCount0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _pushConstantRangeCount) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:485

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->pushConstantRangeCount = (uint32_t) (_pushConstantRangeCount);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPushConstantRangeCount0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:495

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  return (jint) (vkObj->pushConstantRangeCount);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPushConstantRangeCount0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPushConstantRangeCount0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_setPPushConstantRanges0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pPushConstantRanges) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pPushConstantRanges = (char*)(obj__pPushConstantRanges?env->GetDirectBufferAddress(obj__pPushConstantRanges) : NULL);


//@line:504

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const VkPushConstantRange* p_pPushConstantRanges = ( VkPushConstantRange*) _pPushConstantRanges; 
		 vkObj->pPushConstantRanges = p_pPushConstantRanges; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPPushConstantRanges0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:515

		  VkPipelineLayoutCreateInfo* vkObj = (VkPipelineLayoutCreateInfo*)(ptr);
		  // generic get for array of VkHandle and VkStruct 
		  return (jlong) reinterpret_cast<jlong>( vkObj->pPushConstantRanges );
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPPushConstantRanges0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineLayoutCreateInfo_getPPushConstantRanges0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

