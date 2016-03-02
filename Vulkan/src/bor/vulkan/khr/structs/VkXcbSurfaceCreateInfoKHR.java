/**
 * Class wrapping Vulkan's VkXcbSurfaceCreateInfoKHR struct.
 * 
 * Bor_Vulkan Project Ver. 0.8.01 (beta)
 * Licence terms: 
 * The MIT License (MIT)
 * Copyright (c) 2016 Alessandro Borges
 * See https://opensource.org/licenses/MIT 
 */
package bor.vulkan.khr.structs;

import bor.vulkan.*;
import bor.vulkan.enumerations.*;
import bor.vulkan.structs.*;
import bor.vulkan.khr.*;
import java.nio.ByteBuffer;


/**
 *  Class for Java-Vulkan integration 
 *  This class is a Java front end for struct VkXcbSurfaceCreateInfoKHR. 
 *  <h3>Prototype:</h3>
 * <pre>
 * typedef struct VkXcbSurfaceCreateInfoKHR {
 *     VkStructureType               sType;
 *     const void*                   pNext;
 *     VkXcbSurfaceCreateFlagsKHR    flags;
 *     xcb_connection_t*             connection;
 *     xcb_window_t                  window;
 * } VkXcbSurfaceCreateInfoKHR;
 * </pre>
 * 
 * @author Alessandro Borges 
 * @version Ver. 0.8.01 (beta) 
 */
public class VkXcbSurfaceCreateInfoKHR extends VkStruct {
	/** TAG of this structure [243]  */
	 private static final String TAG = "VkXcbSurfaceCreateInfoKHR";

	/** ID of this structure [243]  */
	 public static final int TAG_ID = VKXCBSURFACECREATEINFOKHR_ID;

	 // fields //
	/**
	 *  VkStructureType 	sType	[vkenum]	 */ 
	VkStructureType 	sType;

	/**
	 *  const void* 	pNext		 */ 
	P<VkObject> 	pNext;

	/**
	 *  VkXcbSurfaceCreateFlagsKHR 	flags		 */ 
	int 	flags;

	/**
	 *  xcb_connection_t* 	connection	[vkhandle]	 */ 
	XCBconnection 	connection;

	/**
	 *  xcb_window_t 	window	[vkhandle]	 */ 
	XCBwindow 	window;

	/**
	 * Ctor
	 */
	public VkXcbSurfaceCreateInfoKHR(){ 
		 super(sizeOf()); 
	 }

	/** 
	 * Method to get native size of this structure 
	 */
	 public static int sizeOf(){ 
		 return sizeOf(TAG_ID); 
	}


	 ////////////////////////
	 //  SETTERS & GETTERS //
	 ////////////////////////

	/**
	 * Set method for field sType	[vkenum]
	 * Prototype: VkStructureType  sType
	 */ 
	 public void sType(VkStructureType sType){
		 this.sType = sType;
		sType0(super.ptr, sType);
	 }

	/**
	 * get method for field sType	[vkenum]
	 * Prototype: VkStructureType  sType
	 */ 
	 public VkStructureType sType(){
		 // return  this.sType;
		 return sType0(super.ptr);
	 }

	/**
	 * Set method for field pNext	
	 * Prototype: const void*  pNext
	 */ 
	 public void pNext(P<VkObject> pNext){
		 this.pNext = pNext;
		pNext0(super.ptr, pNext);
	 }

	/**
	 * get method for field pNext	
	 * Prototype: const void*  pNext
	 */ 
	 public P<VkObject> pNext(){
		 // return  this.pNext;
		 return pNext0(super.ptr);
	 }

	/**
	 * Set method for field flags	
	 * Prototype: VkXcbSurfaceCreateFlagsKHR  flags
	 */ 
	 public void flags(int flags){
		 this.flags = flags;
		flags0(super.ptr, flags);
	 }

	/**
	 * get method for field flags	
	 * Prototype: VkXcbSurfaceCreateFlagsKHR  flags
	 */ 
	 public int flags(){
		 // return  this.flags;
		 return flags0(super.ptr);
	 }

	/**
	 * Set method for field connection	[vkhandle]
	 * Prototype: xcb_connection_t*  connection
	 */ 
	 public void connection(XCBconnection connection){
		 this.connection = connection;
		connection0(super.ptr, connection);
	 }

	/**
	 * get method for field connection	[vkhandle]
	 * Prototype: xcb_connection_t*  connection
	 */ 
	 public XCBconnection connection(){
		 // return  this.connection;
		 return connection0(super.ptr);
	 }

	/**
	 * Set method for field window	[vkhandle]
	 * Prototype: xcb_window_t  window
	 */ 
	 public void window(XCBwindow window){
		 this.window = window;
		window0(super.ptr, window);
	 }

	/**
	 * get method for field window	[vkhandle]
	 * Prototype: xcb_window_t  window
	 */ 
	 public XCBwindow window(){
		 // return  this.window;
		 return window0(super.ptr);
	 }


	 // ////////////////////////////////
	 // native SETTERS & GETTERS //
	 // ////////////////////////////////
	/**
	 * native Set method for field sType	[vkenum]
	 * Prototype: VkStructureType  sType
	 */ 
	 private static native void sType0(ByteBuffer ptr, VkStructureType _sType);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(*ptr);
		  _obj.sType = (VkStructureType) (_sType);
	  */

	/**
	 * get method for field sType	[vkenum]
	 * Prototype: VkStructureType  sType
	 */ 
	 private static native VkStructureType sType0(ByteBuffer ptr);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(ptr);
		  return (VkStructureType) (_obj.VkStructureType);
	 */

	/**
	 * native Set method for field pNext	
	 * Prototype: const void*  pNext
	 */ 
	 private static native void pNext0(ByteBuffer ptr, P<VkObject> _pNext);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(*ptr);
		  _obj.pNext = (const void*) (_pNext);
	  */

	/**
	 * get method for field pNext	
	 * Prototype: const void*  pNext
	 */ 
	 private static native P<VkObject> pNext0(ByteBuffer ptr);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(ptr);
		  return (P<VkObject>) (_obj.const void*);
	 */

	/**
	 * native Set method for field flags	
	 * Prototype: VkXcbSurfaceCreateFlagsKHR  flags
	 */ 
	 private static native void flags0(ByteBuffer ptr, int _flags);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(*ptr);
		  _obj.flags = (VkXcbSurfaceCreateFlagsKHR) (_flags);
	  */

	/**
	 * get method for field flags	
	 * Prototype: VkXcbSurfaceCreateFlagsKHR  flags
	 */ 
	 private static native int flags0(ByteBuffer ptr);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(ptr);
		  return (jint) (_obj.VkXcbSurfaceCreateFlagsKHR);
	 */

	/**
	 * native Set method for field connection	[vkhandle]
	 * Prototype: xcb_connection_t*  connection
	 */ 
	 private static native void connection0(ByteBuffer ptr, XCBconnection _connection);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(*ptr);
		  _obj.connection = (xcb_connection_t*) (_connection);
	  */

	/**
	 * get method for field connection	[vkhandle]
	 * Prototype: xcb_connection_t*  connection
	 */ 
	 private static native XCBconnection connection0(ByteBuffer ptr);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(ptr);
		  return (XCBconnection) (_obj.xcb_connection_t*);
	 */

	/**
	 * native Set method for field window	[vkhandle]
	 * Prototype: xcb_window_t  window
	 */ 
	 private static native void window0(ByteBuffer ptr, XCBwindow _window);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(*ptr);
		  _obj.window = (xcb_window_t) (_window);
	  */

	/**
	 * get method for field window	[vkhandle]
	 * Prototype: xcb_window_t  window
	 */ 
	 private static native XCBwindow window0(ByteBuffer ptr);/*
		  VkXcbSurfaceCreateInfoKHR _obj = (VkXcbSurfaceCreateInfoKHR)(ptr);
		  return (XCBwindow) (_obj.xcb_window_t);
	 */



} // end of class VkXcbSurfaceCreateInfoKHR
