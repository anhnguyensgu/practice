#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Driver.h"
#include "StorageDevice.h"
#include "FileInfo.h"
// #include "StorageDevice.c"

int main()
{
  StorageDevice device = createNewStorage(4096, 40960);
  addFile(device, createNew(5000, "myfile.txt"));
  addFile(device, createNew(3, "456"));
  deleteFile(device, "456");
  // addFile(device, createNew(6000, "myfile.txt"));
  addFile(device, createNew(4096*2, "myfile2.txt"));
  printValues(device);
  freeUpData(device);
}