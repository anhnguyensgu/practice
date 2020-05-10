#ifndef FILEINFO_H
#define FILEINFO_H

typedef struct file_info *FileInfo;
struct file_info {
  char *name;
  int size;
  int start;
  int length;
};

FileInfo createNew(int blockSize, char *name);

#endif



