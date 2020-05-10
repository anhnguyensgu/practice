#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "StorageDevice.h"
#include "FileInfo.h"

// returns the pointer to the list; NULL if list not created
StorageDevice createNewStorage(int blockSize, int size)
{
  // allocate memory for a structure variable containing all
  // list components
  int blockNumber = size / blockSize;
  if (size % blockSize > 0)
  {
    blockNumber++;
  }

  StorageDevice device = malloc(sizeof(struct storage_device));

  device->blockTable = (int **)malloc(blockNumber * sizeof(int *));
  for (int i = 0; i < blockNumber; i++)
  {
    device->blockTable[i] = (int *)malloc(2 * sizeof(int));
    device->blockTable[i][1] = 0;
    device->blockTable[i][0] = 0;
  }

  // if allocation was succesfull
  device->size = size;
  device->currentBlock = 0;
  device->blockSize = blockSize;
  device->blockNumber = blockNumber;
  device->fileSize = 0;
  return device;
}

void addFile(StorageDevice device, FileInfo file)
{
  int usedBlockNumber = file->size / device->blockSize;
  int remainingBlockSize = file->size % device->blockSize;
  device->fileSize = device->fileSize + 1;
  device->files[device->fileSize - 1] = file;
  file->start = device->currentBlock;
  file->length = remainingBlockSize > 0 ? usedBlockNumber + 1 : usedBlockNumber;

  while (usedBlockNumber > 0)
  {
    device->blockTable[device->currentBlock][0] = device->blockSize;
    device->blockTable[device->currentBlock][1] = 0;
    device->currentBlock = device->currentBlock + 1;
    usedBlockNumber--;
  }

  if (remainingBlockSize > 0)
  {
    device->blockTable[device->currentBlock][0] = remainingBlockSize;
    device->blockTable[device->currentBlock][1] = device->blockSize - remainingBlockSize;
    device->currentBlock = device->currentBlock + 1;
  }
}

void deleteFile(StorageDevice device, char *fileName)
{
  for (int i = 0; i <= device->fileSize - 1; i++)
  {
    if (device->files[i]->name == fileName)
    {
      //clean file
      int deletedLength = device->files[i]->length;
      int deletedIndex = device->files[i]->start;
      printf("deleted %d %d\n", deletedIndex, deletedLength);
      for (int j = i; j < device->fileSize - 1; j++)
      {
        // device->files[j] = device->files[j + 1];
        // device->files[j]->start = device->files[j]->start - deletedLength;
        printf("current %d %d %d\n", device->files[j]->start, deletedLength, device->files[j]->start);
        printf("debug %d %d %d\n", device->files[j + 1]->start, deletedLength, device->files[j + 1]->start);
      }
      // free(device->files[device->fileSize - 2]);
      device->fileSize -= 1;
      // device->current -= 1;

      //clean block
      for (int j = deletedIndex; j < deletedIndex + deletedLength; j++)
      {
        device->blockTable[j][0] = 0;
        device->blockTable[j][1] = 0;
      }
      device->blockNumber -= deletedLength;
      break;
    }
  }
}

void printValues(StorageDevice device)
{
  printf("---------------------------------------------------------------------------\n");
  printf("Filename\tSize\tStart\tLength\n");
  for (int i = 0; i <= device->fileSize - 1; i++)
    printf("%s\t%d\t%d\t%d\n", device->files[i]->name, device->files[i]->size, device->files[i]->start, device->files[i]->length);
  printf("---------------------------------------------------------------------------\n");
  printf("Block number\tSize used\tFragmented\n");
  for (int i = 0; i < device->blockNumber; i++)
    printf("%d\t\t%d\t\t%d\n", i, device->blockTable[i][0], device->blockTable[i][1]);
  printf("---------------------------------------------------------------------------\n");
}

void freeUpData(StorageDevice device)
{
  for (int i = 0; i < device->blockNumber; i++)
    free(device->blockTable[i]);
  free(device->blockTable);
}
