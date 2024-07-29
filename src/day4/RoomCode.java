package src.day4;

class RoomCode
{
    public final String name;
    public final int sectorId;
    public final String checksum;

    public RoomCode(String pName, int pSectorId, String pChecksum)
    {
        name = pName;
        sectorId = pSectorId;
        checksum = pChecksum;
    }
}
