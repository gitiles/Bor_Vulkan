#include <bor.vulkan.structs.VkFramebufferCreateInfo.h>

//@line:46

    #include <BorVulkan.hpp>
    JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setSType0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _sType) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:428

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->sType = (VkStructureType) (_sType);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getSType0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:438

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (VkStructureType) (vkObj->sType);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getSType0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getSType0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pNext) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pNext = (char*)(obj__pNext?env->GetDirectBufferAddress(obj__pNext) : NULL);


//@line:447

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for Buffer - referenced by ptr
		  vkObj->pNext = (const void*) (_pNext);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPNext0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:457

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  // generic get for Buffer 
		  return (jlong) reinterpret_cast<jlong>(&vkObj->pNext);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPNext0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPNext0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _flags) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:467

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->flags = (VkFramebufferCreateFlags) (_flags);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getFlags0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:477

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (jint) (vkObj->flags);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getFlags0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getFlags0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setRenderPass0(JNIEnv* env, jclass clazz, jobject obj_ptr, jlong _renderPass) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:486

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->renderPass = (VkRenderPass) (_renderPass);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getRenderPass0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:496

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  // generic get for struct field of type  VkHandle or VkStruct 
		  return (jlong) reinterpret_cast<jlong>(&vkObj->renderPass);
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getRenderPass0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getRenderPass0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setAttachmentCount0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _attachmentCount) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:506

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->attachmentCount = (uint32_t) (_attachmentCount);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getAttachmentCount0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:516

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (jint) (vkObj->attachmentCount);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getAttachmentCount0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getAttachmentCount0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setPAttachments0(JNIEnv* env, jclass clazz, jobject obj_ptr, jobject obj__pAttachments) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);
	char* _pAttachments = (char*)(obj__pAttachments?env->GetDirectBufferAddress(obj__pAttachments) : NULL);


//@line:525

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for Buffer - referenced by ptr
		  vkObj->pAttachments = (const VkImageView*) (_pAttachments);
	  

}

static inline jlong wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPAttachments0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:535

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  // generic get for array of VkHandle and VkStruct 
		  return (jlong) reinterpret_cast<jlong>( &vkObj->pAttachments );
	 
}

JNIEXPORT jlong JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPAttachments0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jlong JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getPAttachments0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setWidth0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _width) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:545

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->width = (uint32_t) (_width);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getWidth0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:555

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (jint) (vkObj->width);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getWidth0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getWidth0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setHeight0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _height) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:564

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->height = (uint32_t) (_height);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getHeight0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:574

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (jint) (vkObj->height);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getHeight0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getHeight0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_setLayers0(JNIEnv* env, jclass clazz, jobject obj_ptr, jint _layers) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);


//@line:583

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		 // code for simple past value 
		  vkObj->layers = (uint32_t) (_layers);
	  

}

static inline jint wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getLayers0
(JNIEnv* env, jclass clazz, jobject obj_ptr, unsigned char* ptr) {

//@line:593

		  VkFramebufferCreateInfo* vkObj = (VkFramebufferCreateInfo*)(ptr);
		  return (jint) (vkObj->layers);
	 
}

JNIEXPORT jint JNICALL Java_bor_vulkan_structs_VkFramebufferCreateInfo_getLayers0(JNIEnv* env, jclass clazz, jobject obj_ptr) {
	unsigned char* ptr = (unsigned char*)(obj_ptr?env->GetDirectBufferAddress(obj_ptr) : NULL);

	jint JNI_returnValue = wrapped_Java_bor_vulkan_structs_VkFramebufferCreateInfo_getLayers0(env, clazz, obj_ptr, ptr);


	return JNI_returnValue;
}
