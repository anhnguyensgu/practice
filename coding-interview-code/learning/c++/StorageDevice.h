#ifndef S_H
#define S_H
#include "FileInfo.h"

struct storage_device
{
  int size;
  int blockSize;
  int **blockTable;
  int currentBlock;
  int blockNumber;
  int fileSize;
  FileInfo *files;
};

typedef struct storage_device *StorageDevice;

StorageDevice createNewStorage(int blockSize, int size);
void addFile(StorageDevice device, FileInfo file);
void deleteFile(StorageDevice device, char* name);
void printValues(StorageDevice device);
void freeUpData(StorageDevice device);
#endif



