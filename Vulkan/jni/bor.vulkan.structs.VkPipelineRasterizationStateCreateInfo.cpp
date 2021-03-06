#include <bor.vulkan.structs.VkPipelineRasterizationStateCreateInfo.h>

//@line:50

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setSType0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _sType) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:544

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->sType = (VkStructureType) (_sType);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getSType0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:554

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->sType);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getSType0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getSType0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pNext) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pNext = (char*)(obj__pNext?env->GetDirectBufferAddress(obj__pNext) : NULL);


//@line:564

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for Buffer - ptr to ptr 
		 const void* p_pNext = ( void*) _pNext; 
		 vkObj->pNext = p_pNext; 
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPNext0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:575

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  // generic get for Buffer - field must be pointer! 
		  return (jlong) reinterpret_cast<jlong>(vkObj->pNext);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPNext0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _flags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:585

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->flags = (VkPipelineRasterizationStateCreateFlags) (_flags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:595

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jint) (vkObj->flags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setDepthClampEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr, jboolean _depthClampEnable) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:604

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->depthClampEnable = (VkBool32) (_depthClampEnable);
	  

}

static inline jboolean wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthClampEnable0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:614

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jboolean) (vkObj->depthClampEnable);
	 
}

JNIEXPORT jboolean JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthClampEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jboolean JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthClampEnable0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setRasterizerDiscardEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr, jboolean _rasterizerDiscardEnable) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:623

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->rasterizerDiscardEnable = (VkBool32) (_rasterizerDiscardEnable);
	  

}

static inline jboolean wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getRasterizerDiscardEnable0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:633

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jboolean) (vkObj->rasterizerDiscardEnable);
	 
}

JNIEXPORT jboolean JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getRasterizerDiscardEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jboolean JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getRasterizerDiscardEnable0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setPolygonMode0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _polygonMode) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:642

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->polygonMode = (VkPolygonMode) (_polygonMode);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPolygonMode0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:652

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->polygonMode);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPolygonMode0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getPolygonMode0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setCullMode0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _cullMode) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:662

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->cullMode = (VkCullModeFlags) (_cullMode);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getCullMode0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:672

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jint) (vkObj->cullMode);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getCullMode0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getCullMode0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setFrontFace0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _frontFace) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:681

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->frontFace = (VkFrontFace) (_frontFace);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFrontFace0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:691

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  // generic get for Vk enums
		  return (jint) (vkObj->frontFace);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFrontFace0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getFrontFace0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setDepthBiasEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr, jboolean _depthBiasEnable) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:701

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->depthBiasEnable = (VkBool32) (_depthBiasEnable);
	  

}

static inline jboolean wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasEnable0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:711

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jboolean) (vkObj->depthBiasEnable);
	 
}

JNIEXPORT jboolean JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasEnable0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jboolean JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasEnable0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setDepthBiasConstantFactor0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloat _depthBiasConstantFactor) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:720

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->depthBiasConstantFactor = (float) (_depthBiasConstantFactor);
	  

}

static inline jfloat wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasConstantFactor0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:730

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jfloat) (vkObj->depthBiasConstantFactor);
	 
}

JNIEXPORT jfloat JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasConstantFactor0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jfloat JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasConstantFactor0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setDepthBiasClamp0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloat _depthBiasClamp) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:739

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->depthBiasClamp = (float) (_depthBiasClamp);
	  

}

static inline jfloat wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasClamp0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:749

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jfloat) (vkObj->depthBiasClamp);
	 
}

JNIEXPORT jfloat JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasClamp0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jfloat JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasClamp0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setDepthBiasSlopeFactor0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloat _depthBiasSlopeFactor) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:758

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->depthBiasSlopeFactor = (float) (_depthBiasSlopeFactor);
	  

}

static inline jfloat wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasSlopeFactor0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:768

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jfloat) (vkObj->depthBiasSlopeFactor);
	 
}

JNIEXPORT jfloat JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasSlopeFactor0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jfloat JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getDepthBiasSlopeFactor0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_setLineWidth0(JNIEnv* env, jclass clazz, jobject obj_ptr, jfloat _lineWidth) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:777

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->lineWidth = (float) (_lineWidth);
	  

}

static inline jfloat wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getLineWidth0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:787

		  VkPipelineRasterizationStateCreateInfo* vkObj = (VkPipelineRasterizationStateCreateInfo*)(ptr);
		  return (jfloat) (vkObj->lineWidth);
	 
}

JNIEXPORT jfloat JNICALL Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getLineWidth0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jfloat JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkPipelineRasterizationStateCreateInfo_getLineWidth0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

