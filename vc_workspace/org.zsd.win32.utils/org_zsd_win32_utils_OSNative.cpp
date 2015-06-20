#include "stdafx.h"
#include "org_zsd_win32_utils_OSNative.h"

#define OS_NATIVE(func) Java_org_zsd_win32_utils_OSNative_##func

JNIEXPORT void JNICALL OS_NATIVE(PostQuitMessage)(JNIEnv *env, jclass cls, jint nExitCode) {
	PostQuitMessage(nExitCode);
}

JNIEXPORT jint JNICALL OS_NATIVE(char_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(char);
}

JNIEXPORT jint JNICALL OS_NATIVE(wchar_1t_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(wchar_t);
}

JNIEXPORT jint JNICALL JNICALL OS_NATIVE(short_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(short);
}

JNIEXPORT jint JNICALL OS_NATIVE(int_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(int);
}

JNIEXPORT jint JNICALL OS_NATIVE(long_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(long);
}

JNIEXPORT jint JNICALL OS_NATIVE(handle_1sizeof) (JNIEnv *env, jclass cls) {
	return sizeof(HANDLE);
}

JNIEXPORT jint JNICALL OS_NATIVE(AllocateBuffer) (JNIEnv *env, jclass cls, jint ulSize) {
	LPVOID lpMem = HeapAlloc(GetProcessHeap(), HEAP_ZERO_MEMORY, ulSize + sizeof(HANDLE));
	return (jint)lpMem + sizeof(HANDLE);
}

JNIEXPORT jint JNICALL OS_NATIVE(AllocateMore) (JNIEnv *env, jclass cls, jint ulSize, jint lpvOriginal) {
	LPVOID lpMem = HeapAlloc(GetProcessHeap(), HEAP_ZERO_MEMORY, ulSize + sizeof(HANDLE));
	LPHANDLE ptr = (LPHANDLE)(lpvOriginal - sizeof(HANDLE));
	while(*ptr) {
		ptr = (LPHANDLE)*ptr;
	}
	*ptr = (HANDLE)lpMem;
	return (jint)lpMem + sizeof(HANDLE);
}

JNIEXPORT void JNICALL OS_NATIVE(FreeBuffer) (JNIEnv *env, jclass cls, jint lpvOriginal) {
	LPHANDLE ptr = (LPHANDLE)(lpvOriginal - sizeof(HANDLE));
	while(ptr) {
		LPHANDLE temp = ptr;
		ptr = (LPHANDLE)*ptr;
		HeapFree(GetProcessHeap(), 0, (LPVOID)temp);
	}
}

JNIEXPORT void JNICALL OS_NATIVE(setByteArray) (JNIEnv *env, jclass cls, jint lpBuffer, jbyteArray array) {
	env->GetByteArrayRegion(array, 0, env->GetArrayLength(array), (jbyte*)lpBuffer);
}

JNIEXPORT jbyteArray JNICALL OS_NATIVE(getByteArray__I) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	jbyte* buf = (jbyte*)lpBuffer;
	while(*buf++) {
		length++;
	}
	jbyteArray array = env->NewByteArray(length);
	env->SetByteArrayRegion(array, 0, length, (jbyte*)lpBuffer);
	return array;
}

JNIEXPORT jbyteArray JNICALL OS_NATIVE(getByteArray__II) (JNIEnv *env, jclass cls, jint lpBuffer, jint length) {
	jbyteArray array = env->NewByteArray(length);
	env->SetByteArrayRegion(array, 0, length, (jbyte*)lpBuffer);
	return array;
}

JNIEXPORT void JNICALL OS_NATIVE(setShortArray) (JNIEnv *env, jclass cls, jint lpBuffer, jshortArray array) {
	env->GetShortArrayRegion(array, 0, env->GetArrayLength(array), (jshort*)lpBuffer);
}

JNIEXPORT jshortArray JNICALL OS_NATIVE(getShortArray__I) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	jshort* buf = (jshort*)lpBuffer;
	while(*buf++) {
		length++;
	}
	jshortArray array = env->NewShortArray(length);
	env->SetShortArrayRegion(array, 0, length, (jshort*)lpBuffer);
	return array;
}

JNIEXPORT jshortArray JNICALL OS_NATIVE(getShortArray__II) (JNIEnv *env, jclass cls, jint lpBuffer, jint length) {
	jshortArray array = env->NewShortArray(length);
	env->SetShortArrayRegion(array, 0, length, (jshort*)lpBuffer);
	return array;
}

JNIEXPORT void JNICALL OS_NATIVE(setIntArray) (JNIEnv *env, jclass cls, jint lpBuffer, jintArray array) {
	env->GetIntArrayRegion(array, 0, env->GetArrayLength(array), (jint*)lpBuffer);
}

JNIEXPORT jintArray JNICALL OS_NATIVE(getIntArray__I) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	jint* buf = (jint*)lpBuffer;
	while(*buf++) {
		length++;
	}
	jintArray array = env->NewIntArray(length);
	env->SetIntArrayRegion(array, 0, length, (jint*)lpBuffer);
	return array;
}

JNIEXPORT jintArray JNICALL OS_NATIVE(getIntArray__II) (JNIEnv *env, jclass cls, jint lpBuffer, jint length) {
	jintArray array = env->NewIntArray(length);
	env->SetIntArrayRegion(array, 0, length, (jint*)lpBuffer);
	return array;
}

JNIEXPORT void JNICALL OS_NATIVE(setLongArray) (JNIEnv *env, jclass cls, jint lpBuffer, jlongArray array) {
	env->GetLongArrayRegion(array, 0, env->GetArrayLength(array), (jlong*)lpBuffer);
}

JNIEXPORT jlongArray JNICALL OS_NATIVE(getLongArray__I) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	jlong* buf = (jlong*)lpBuffer;
	while(*buf++) {
		length++;
	}
	jlongArray array = env->NewLongArray(length);
	env->SetLongArrayRegion(array, 0, length, (jlong*)lpBuffer);
	return array;
}

JNIEXPORT jlongArray JNICALL OS_NATIVE(getLongArray__II) (JNIEnv *env, jclass cls, jint lpBuffer, jint length) {
	jlongArray array = env->NewLongArray(length);
	env->SetLongArrayRegion(array, 0, length, (jlong*)lpBuffer);
	return array;
}

//double-null-terminated string is really a list of strings with an empty string as the terminator
JNIEXPORT jbyteArray JNICALL OS_NATIVE(getDoubleNullTerminatedByteArray) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	for (char* ptr = (char*)lpBuffer; *ptr; ptr += strlen(ptr) + 1) {
		length++;
	}
	jbyteArray array = env->NewByteArray(length);
	env->SetByteArrayRegion(array, 0, length, (jbyte*)lpBuffer);
	return array;
}

JNIEXPORT jstring JNICALL OS_NATIVE(getNullTerminatedCString) (JNIEnv *env, jclass cls, jint lpBuffer) {
	return env->NewStringUTF((char*)lpBuffer);
}

JNIEXPORT jstring JNICALL OS_NATIVE(getNullTerminatedCWideString) (JNIEnv *env, jclass cls, jint lpBuffer) {
	return env->NewString((jchar*)lpBuffer, wcslen((wchar_t*)lpBuffer));
}

JNIEXPORT jobjectArray JNICALL OS_NATIVE(getDoubleNullTerminatedCString) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	for (char* ptr = (char*)lpBuffer; *ptr; ptr += strlen(ptr) + 1) {
		length++;
	}
	jclass elementClass = env->FindClass("java/lang/String");
	jobjectArray array = env->NewObjectArray(length, elementClass, NULL);
	
	int index = 0;
	for (char* ptr = (char*)lpBuffer; *ptr; ptr += strlen(ptr) + 1) {
		env->SetObjectArrayElement(array, index++, env->NewStringUTF(ptr));
	}
	return array;
}

JNIEXPORT jobjectArray JNICALL OS_NATIVE(getDoubleNullTerminatedCWideString) (JNIEnv *env, jclass cls, jint lpBuffer) {
	jint length = 0;
	for (wchar_t* ptr = (wchar_t*)lpBuffer; *ptr; ptr += wcslen(ptr) + 1) {
		length++;
	}
	jclass elementClass = env->FindClass("java/lang/String");
	jobjectArray array = env->NewObjectArray(length, elementClass, NULL);
	
	int index = 0;
	for (wchar_t* ptr = (wchar_t*)lpBuffer; *ptr; ptr += wcslen(ptr) + 1) {
		env->SetObjectArrayElement(array, index++, env->NewString((jchar*)ptr, wcslen(ptr)));
	}
	return array;
}

JNIEXPORT jstring JNICALL OS_NATIVE(getCWideString) (JNIEnv *env, jclass cls, jint lpBuffer, jint length) {
	return env->NewString((const jchar*)lpBuffer, length);
}

JNIEXPORT void JNICALL OS_NATIVE(setCString) (JNIEnv *env, jclass cls, jint lpBuffer, jstring string) {
	const char* ptr = env->GetStringUTFChars(string, NULL);
	int length = env->GetStringUTFLength(string);
	strncpy((char*)lpBuffer, ptr, length);
	env->ReleaseStringUTFChars(string, ptr);
}

JNIEXPORT void JNICALL OS_NATIVE(setCWideString) (JNIEnv *env, jclass cls, jint lpBuffer, jstring string) {
	const jchar* ptr = env->GetStringChars(string, NULL);
	int length = env->GetStringLength(string);
	wcsncpy((wchar_t*)lpBuffer, (wchar_t*)ptr, length);
	env->ReleaseStringChars(string, ptr);
}