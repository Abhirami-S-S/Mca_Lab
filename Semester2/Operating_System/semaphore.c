#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define MAX_THREADS 5

sem_t semaphore;   // Counting semaphore
int shared = 0;

void* worker(void* arg) {
    int id = *(int*)arg;

    printf("Thread %d is waiting...\n", id);

    sem_wait(&semaphore);  // Request access

    // CRITICAL SECTION (only 2 threads allowed here)
    printf("Thread %d ENTERED critical section\n", id);

    int local = shared;
    sleep(1); // simulate processing
    local++;
    shared = local;

    printf("Thread %d UPDATED shared = %d\n", id, shared);

    sleep(1);

    printf("Thread %d EXITING critical section\n", id);

    sem_post(&semaphore);  // Release access

    return NULL;
}

int main() {
    pthread_t threads[MAX_THREADS];
    int ids[MAX_THREADS];

    // Initialize semaphore with value 2 (allow 2 threads)
    sem_init(&semaphore, 0, 2);

    for(int i = 0; i < MAX_THREADS; i++) {
        ids[i] = i + 1;
        pthread_create(&threads[i], NULL, worker, &ids[i]);
    }

    for(int i = 0; i < MAX_THREADS; i++) {
        pthread_join(threads[i], NULL);
    }

    sem_destroy(&semaphore);

    printf("Final value of shared = %d\n", shared);

    return 0;
}