#include "FileInfo.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

// returns the pointer to the list; NULL if list not created
FileInfo createNew(int size, char *name)
{
  // allocate memory for a structure variable containing all
  // list components
  FileInfo file = malloc(sizeof(struct file_info));
  file->size = size;
  file->name = name;
  // if allocation was succesfull
  return file;
}
