#include <bor.vulkan.structs.VkPipelineColorBlendStateCreateInfo.h>

//@line:45

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setSType0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _sType) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:406

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->sType = (VkStructureType) (_sType);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getSType0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:416

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->sType);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getSType0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getSType0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pNext) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pNext = (char*)(obj__pNext?env->GetDirectBufferAddress(obj__pNext) : NULL);


//@line:426

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const void* p_pNext = ( void*) _pNext; 
		 vkObj->pNext = p_pNext; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPNext0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:437

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  // generic get for Buffer - field must be pointer! 
		  return (jlong) reinterpret_cast<jlong>(vkObj->pNext);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPNext0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _flags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:447

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->flags = (VkPipelineColorBlendStateCreateFlags) (_flags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:457

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  return (jint) (vkObj->flags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setLogicOpEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr, jboolean _logicOpEnable) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:466

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->logicOpEnable = (VkBool32) (_logicOpEnable);
	  

}

static inline jboolean wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOpEnable0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:476

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  return (jboolean) (vkObj->logicOpEnable);
	 
}

JNIEXPORT jboolean JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOpEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jboolean JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOpEnable0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setLogicOp0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _logicOp) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:485

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->logicOp = (VkLogicOp) (_logicOp);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOp0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:495

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->logicOp);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOp0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getLogicOp0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setAttachmentCount0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _attachmentCount) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:505

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->attachmentCount = (uint32_t) (_attachmentCount);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getAttachmentCount0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:515

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  return (jint) (vkObj->attachmentCount);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getAttachmentCount0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getAttachmentCount0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setPAttachments0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pAttachments) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pAttachments = (char*)(obj__pAttachments?env->GetDirectBufferAddress(obj__pAttachments) : NULL);


//@line:524

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const VkPipelineColorBlendAttachmentState* p_pAttachments = ( VkPipelineColorBlendAttachmentState*) _pAttachments; 
		 vkObj->pAttachments = p_pAttachments; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPAttachments0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:535

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  // generic get for array of VkHandle and VkStruct 
		  return (jlong) reinterpret_cast<jlong>( vkObj->pAttachments );
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPAttachments0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getPAttachments0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_setBlendConstants0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloatArray obj__blendConstants) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	float* _blendConstants = (float*)(obj__blendConstants ? env->GetFloatArrayElements(obj__blendConstants, 0) : NULL);


//@line:545

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		 // code for fixed size array 
		  memcpy(vkObj->blendConstants, _blendConstants, 4 * sizeof(float));
	  
	if(obj__blendConstants != NULL){
		 env->ReleaseFloatArrayElements(obj__blendConstants, (jfloat*)_blendConstants, 0);
	}

}

static inline jfloatArray wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getBlendConstants0
(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloatArray obj__blendConstants, unsigned char* ptr, float* _blendConstants) {

//@line:555

		  VkPipelineColorBlendStateCreateInfo* vkObj = (VkPipelineColorBlendStateCreateInfo*)(ptr);
		  // fixed length array  
		  memcpy(_blendConstants, vkObj->blendConstants, 4 * sizeof(float));
		  return obj__blendConstants;
	 
}

JNIEXPORT jfloatArray JNICALL Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getBlendConstants0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloatArray obj__blendConstants) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	float* _blendConstants = (float*)(obj__blendConstants ? env->GetFloatArrayElements(obj__blendConstants, 0) : NULL);

	jfloatArray JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineColorBlendStateCreateInfo_getBlendConstants0(env, clazz, obj_ptr, obj__blendConstants, ptr, _blendConstants);

	if(obj__blendConstants != NULL){
		 env->ReleaseFloatArrayElements(obj__blendConstants, (jfloat*)_blendConstants, 0);
	}

	return JNI_returnValue;
}

